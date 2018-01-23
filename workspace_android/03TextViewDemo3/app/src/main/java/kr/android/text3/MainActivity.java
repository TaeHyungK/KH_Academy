package kr.android.text3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView 객체 생성
        TextView tv = new TextView(this);
        //문자열 입력
        tv.setText("텍스트 직접 입력");

        setContentView(tv);
    }
}
