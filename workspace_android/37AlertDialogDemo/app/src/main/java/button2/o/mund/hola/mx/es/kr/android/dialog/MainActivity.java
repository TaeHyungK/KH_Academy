package button2.o.mund.hola.mx.es.kr.android.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                new AlertDialog.Builder(this)
                                .setTitle("대화 상자")
                                .setMessage("안녕하세요!")
                                .setCancelable(false)
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //AlertDialog가 닫힐 때 호출되며 창이 닫힐 때 추가 작업이 없으면 코드를 명시하지 않으면 됨

                                    }
                                })
                                .show();

                break;
        }
    }

}
