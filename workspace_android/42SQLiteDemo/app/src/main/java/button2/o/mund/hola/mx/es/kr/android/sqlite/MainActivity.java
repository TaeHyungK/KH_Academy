package button2.o.mund.hola.mx.es.kr.android.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    static final String TAG = "SQLMemo";

    private TextView mCurrentId;
    private EditText mEdit;
    private SimpleCursorAdapter mAdapter;
    private DatabaseAdapter dbAdapter;
    private ListView list;

    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentId = (TextView)findViewById(R.id.view_id);
        mEdit = (EditText)findViewById(R.id.edit_memo);
        list = (ListView)findViewById(R.id.list);

        //버튼 등록
        int buttons[] = {R.id.delete_btn,R.id.modify_btn,R.id.add_btn};

        //이벤트 연결
        for(int id : buttons){
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this);
        }
    }

    //작업이 포그라운드 상태가 아닌 경우 DB를  close 하기
    @Override
    protected void onPause() {
        super.onPause();
        c.close(); //Cursor close
        dbAdapter.close(); //SQLiteDatabase close
    }

    //작업이 포그라운드 된 시간에 데이터를 표시


    @Override
    protected void onResume() {
        super.onResume();
        //DatabaseAdapter 호출
        dbAdapter = new DatabaseAdapter(this);
        //SQLiteDatabase 생성
        dbAdapter.open();
    }

    //이벤트 핸들러
    @Override
    public void onClick(View view) {
        String content = mEdit.getText().toString();
        if (view.getId() == R.id.add_btn) {
            if (content.length() > 0) {
                dbAdapter.addMemo(content);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}