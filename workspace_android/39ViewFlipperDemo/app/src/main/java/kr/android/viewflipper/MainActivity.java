package kr.android.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper flipper;
    Button btnPrev, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper)findViewById(R.id.details);

        btnPrev = (Button)findViewById(R.id.prev);
        btnNext = (Button)findViewById(R.id.next);

        //이벤트 연결
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.next){
            flipper.showNext();
        }else if(view.getId() == R.id.prev){
            flipper.showPrevious();
        }
    }
}
