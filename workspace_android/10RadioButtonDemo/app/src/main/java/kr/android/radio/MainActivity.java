package kr.android.radio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup group;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.radioGroup);
        tv = (TextView) findViewById(R.id.textView);

        //이벤트 소스와 이벤트 리스너 연결
        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //checkedId : 선택한 RadioButton의 id
        RadioButton rb = (RadioButton) findViewById(checkedId);
        tv.setText("당신의 선택 : " + rb.getText());
    }
}
