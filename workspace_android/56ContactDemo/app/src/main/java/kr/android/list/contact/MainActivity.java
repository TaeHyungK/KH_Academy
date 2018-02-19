package kr.android.list.contact;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.pick);
        btn2 = findViewById(R.id.view);

        //이벤트 연결
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //연락처 불러오기
                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people"));
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //연락처 중 1번 불러오기
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/1"));
                startActivity(intent);
            }
        });
    }
}
