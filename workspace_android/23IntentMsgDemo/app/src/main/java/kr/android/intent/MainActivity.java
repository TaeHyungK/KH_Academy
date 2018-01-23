package kr.android.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        //이벤트 연결
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    //이벤트 핸들러
    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.button:
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                break;
            case R.id.button2:
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("msg", "MainActivity에서 전달한 데이터");
                break;
        }
        //intent를 실행시켜서 intent에 명시된 activity를 구동시킴
        startActivity(intent);

    }
}
