package kr.android.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        if(intent.getExtras() == null){ //전달된 데이터가 없음
            textView.append("\n전달된 데이터 없음");
        }else{
            String msg = intent.getStringExtra("msg");
            textView.append("\n" + msg);
        }

    }
}
