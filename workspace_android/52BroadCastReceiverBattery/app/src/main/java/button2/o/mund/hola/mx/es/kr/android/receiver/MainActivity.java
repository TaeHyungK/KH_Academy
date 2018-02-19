package button2.o.mund.hola.mx.es.kr.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBattery;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //타이틀 변경
        setTitle("배터리 상태 체크");

        ivBattery = findViewById(R.id.ivBattery);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //수신자 등록 해제
        unregisterReceiver(br);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //인텐트 필터(IntentFilter)는 컴포넌트의 윽징을 정함
        //ACTION_ATTERY_CHANGED : 배터리 충전 상태 변경
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //수신자 등록
        registerReceiver(br, filter);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                textView.append("현재 충전량 : " + remain + "%\n");
                if (remain >= 90) {
                    ivBattery.setImageResource(R.drawable.battery_100);
                } else if (remain >= 70) {
                    ivBattery.setImageResource(R.drawable.battery_80);
                } else if (remain >= 50) {
                    ivBattery.setImageResource(R.drawable.battery_60);
                } else if (remain >= 10) {
                    ivBattery.setImageResource(R.drawable.battery_20);
                } else{
                    ivBattery.setImageResource(R.drawable.battery_0);
                }
            }
        }
    };
}
