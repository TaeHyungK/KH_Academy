package kr.android.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar bar;

    //백그라운드 스레드와 통신(백그라운드 스레드오 사용자 인터페이스 연결)
    Handler handler = new Handler();
    boolean isRnning = false; //스레드 종료 제어

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar)findViewById(R.id.progress);
    }

    @Override
    public void onStart(){
        super.onStart();

        //ProgressBar 초기화
        bar.setProgress(0);

        //화면 인터페이스와 별도의 백그라운드 작업을 위해 스레드 생성
        Thread backgroud = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(int i=0;i<20 && isRnning;i++){
                        Thread.sleep(1000);

                        //사용자 인터페이스에 데이터를 표시
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //화면의 데이터 갱신
                                bar.incrementProgressBy(5);
                            }
                        });

                    }
                }catch(Exception e){
                    Log.e("HandlerDemo",e.toString());
                }
            }
        });

        isRnning = true;
        backgroud.start(); //스레드 실행

    }
    @Override
    public void onStop(){
        super.onStop();
        //스레드를 중지시켜서 데이터 읽기 중단
        isRnning = false;
    }
}
