package button2.o.mund.hola.mx.es.kr.android.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar bar;

    //백그라운드 스레드와 통신(백그라운드 스레드와 사용자 인터페이스 연결)
    Handler handler = new Handler();
    boolean isRunning = false; // 스레드 종료 제어

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = findViewById(R.id.progress);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //스레드를 중지시켜서 데이터 읽기 중단
        isRunning = false;
    }
}
