package kr.android.button2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        //이벤트 소스와 이벤트 리스너가 구현된 객체를 연결
        //(익명 객체 형태)
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });
        //초기 값 셋팅
        updateTime();
    }

    private void updateTime(){
        btn.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()));
    }
}
