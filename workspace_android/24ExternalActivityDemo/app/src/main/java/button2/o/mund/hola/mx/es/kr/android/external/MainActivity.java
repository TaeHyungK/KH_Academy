package button2.o.mund.hola.mx.es.kr.android.external;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //레이아웃 직접 생성
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.rgb(255,255,255));
        layout.setOrientation(LinearLayout.VERTICAL);

        //뷰 지정
        setContentView(layout);

        //버튼 생성
        layout.addView(makeButton(0, "Web 페이지 표시: naver"));
        layout.addView(makeButton(1, "다이얼러 표시"));
        layout.addView(makeButton(2, "설정화면 표시"));
        layout.addView(makeButton(3,"지도 표시:seoul"));
    }

    //버튼 생성
    private Button makeButton(int id, String text){
        Button bnt = new Button(this);
        bnt.setId(id);
        bnt.setText(text);
        //이벤트 연결
        bnt.setOnClickListener(this);
        setLLParams(bnt);
        return bnt;
    }

    //리니어 레이아웃의 파라미터 설정
    private void setLLParams(View view){
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case 0://웹페이지 표시
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                break;
            case 1://다이얼러 표시
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678"));
                break;
            case 2://설정화면 표시
                intent = new Intent("android.settings.SETTINGS");
                break;
            case 3://지도 표시:seoul
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=seoul"));
                break;
        }
        startActivity(intent);
    }

}
