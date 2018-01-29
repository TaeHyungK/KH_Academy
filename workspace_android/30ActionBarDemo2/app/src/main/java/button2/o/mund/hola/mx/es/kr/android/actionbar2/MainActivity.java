package button2.o.mund.hola.mx.es.kr.android.actionbar2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu_main.xml을 읽어들여서 Menu 생성
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg =null;
        switch(item.getItemId()){
            case R.id.menu_search:
                msg = "Search 선택";
                break;
            case R.id.menu_chat:
                msg = "Chat 선택";
                break;
            case R.id.menu_email:
                msg ="Email 선택";
                break;
            case R.id.action_settings:
                msg = "환경 설정";
                break;
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
