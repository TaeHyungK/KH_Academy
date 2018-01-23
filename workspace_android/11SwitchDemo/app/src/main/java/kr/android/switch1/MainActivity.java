package kr.android.switch1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Switch.OnCheckedChangeListener{

    Switch switchView;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchView = (Switch) findViewById(R.id.switchView);
        tv = (TextView) findViewById(R.id.textView);

        switchView.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (switchView.isChecked()) {
            tv.setText("절전 기능 사용");
        }else{
            tv.setText("절전 기능 미사용");
        }
    }
}
