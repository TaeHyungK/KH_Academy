package button2.o.mund.hola.mx.es.kr.android.fragment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        //이벤트 연결
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.add(R.id.content, new FragmentOne());
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {
        Fragment fr = null;
        switch (view.getId()){
            case R.id.button1:
                fr = new FragmentOne();
                break;

            case R.id.button2:
                fr = new FragmentTwo();
                break;

            case R.id.button3:
                fr = new FragmentThree();
                break;
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content, fr);
        fragmentTransaction.commit();

    }
}
