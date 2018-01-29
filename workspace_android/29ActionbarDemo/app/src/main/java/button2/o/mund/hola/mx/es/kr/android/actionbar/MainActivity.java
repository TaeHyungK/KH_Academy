package button2.o.mund.hola.mx.es.kr.android.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        //ActionBar 숨기기
        actionBar.hide();
        //ActionBar 보이기
        actionBar.show();

        //타이틀 셋팅
        actionBar.setTitle("Action Bar");
        //서브타이틀 셋팅
        actionBar.setSubtitle("SubtitleofAction Bar");

        //액션바 아이콘(클릭 안 됨)
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);

        /*//홈 아이콘(<- 모양) 노출(클릭 됨)
        actionBar.setDisplayHomeAsUpEnabled(true);
        //홈 인디케이터 모양 지정(R.mipmap.ic_launcher 지정 가능)
        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_input_add);*/

        //setDisplayOptions 메소드 이용하기 (클릭 됨)
        //홈 아이콘(<-모양)노출 및 제목 표시
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        //홈 이벤트에 대한 처리
        switch(item.getItemId()){
            case android.R.id.home: //홈버튼
                Toast.makeText(this, "홈 클릭!!", Toast.LENGTH_SHORT).show();
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
