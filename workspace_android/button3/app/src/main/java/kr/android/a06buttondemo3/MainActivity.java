package kr.android.a06buttondemo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        //초기값 셋팅
        updateTime();
    }

    //activity_main.xml에서 이벤트 핸들러로 지정
    public void onClick(View view) {
        updateTime();
    }

    private void updateTime(){
        button.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()));
    }
}
