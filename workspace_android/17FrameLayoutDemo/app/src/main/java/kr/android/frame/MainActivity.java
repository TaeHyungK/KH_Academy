package kr.android.frame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        //이벤트 연결
        btn.setOnClickListener(new View.OnClickListener() {
            //이벤트 핸들러
            @Override
            public void onClick(View view) {
                if(img.getVisibility() == View.VISIBLE){
                    img.setVisibility(View.GONE);
                }else{
                    img.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
