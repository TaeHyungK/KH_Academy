package button2.o.mund.hola.mx.es.kr.android.actionbar3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        //컨텍스트 메뉴를 연결할 View 인스턴스 등록
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //context_menu.xml를 읽어들여 MenuItem을 생성
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.text_color:
                text.setTextColor(Color.RED);
                break;
            case R.id.text_back_color:
                text.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.text_basic:
                text.setBackgroundColor(Color.TRANSPARENT); //무색, 색깔이 없는 것
                text.setTextColor(Color.BLACK);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
