package kr.android.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        int buttons[] = {R.id.delete_button,R.id.modify_button,R.id.add_button};

        //이벤트 연결
        for(int id : buttons){
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this);
        }
        //수정 삭제 버튼 비활성화
        setEnabled(false);
    }

    //작업이 포그라운드 상태가 아닌 경우 DB를 close 하기
    @Override
    protected void onPause(){
        super.onPause();
        c.close(); //Cursor close
        dbAdapter.close();//SQLiteDatabase close
    }

    //작업이 포그라운드 된 시간에 데이터를 표시
    @Override
    protected void onResume(){
        super.onResume();
        //DatabaseAdapter 호출
        dbAdapter = new DatabaseAdapter(this);
        //SQLiteDatabase 생성
        dbAdapter.open();

        //목록처리를 위해서 fetchAllMemo메서드를 호출하고 Cursor 반환
        c = dbAdapter.fetchAllMemo();

        //데이터베이스 컬럼과 뷰를 연결
        String[] from = DatabaseAdapter.PROJECTION;// _id, content
        //뷰의 id를 표시하는 _id, content를 표시하는 memo_text
        int[] to = new int[]{R.id._id,R.id.memo_text};

        //어댑터 생성
        mAdapter = new SimpleCursorAdapter(this,R.layout.memo_row, c,from,to,SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        //ListView에 어댑터 등록
        list.setAdapter(mAdapter);
        //이벤트 연결
        list.setOnItemClickListener(this);
    }

    //이벤트 핸들러
    @Override
    public void onClick(View view) {
        String content = mEdit.getText().toString();
        String id = mCurrentId.getText().toString();
        if(view.getId() == R.id.add_button){
            if(content.length()>0){
                dbAdapter.addMemo(content);
                //검색
                toastMemo(content);
            }else{
                Toast.makeText(this,"메모를 입력하세요!",Toast.LENGTH_SHORT).show();
            }
        }else if(view.getId() == R.id.modify_button){
            if(content.length()>0){
                dbAdapter.setMemo(id,content);
                //검색
                toastMemo(content);
            }else{
                Toast.makeText(this,"수정할 데이터를 입력하세요",Toast.LENGTH_SHORT).show();
            }
        }else if(view.getId() == R.id.delete_button){
            dbAdapter.deleteMemo(id);
        }

        //TextView 초기화
        mCurrentId.setText("ID");
        //EditText 초기화
        mEdit.setText("");
        //수정,삭제 버튼 비활성화
        setEnabled(false);

        //추가,수정,삭제된 데이터를 읽어옴
        c = dbAdapter.fetchAllMemo();
        //기존의 Cursor를 새로 반환받은 Cursor로 교체
        mAdapter.changeCursor(c);
    }

    //목록을 탭했을 때 호출되는 메서드
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //탭된 행의 ID와 메모 내용을 읽어들여서 텍스트 편집 화면으로 설정
        LinearLayout layout = (LinearLayout)view;
        //메모 내용
        TextView t = (TextView)layout.findViewById(R.id.memo_text);
        mEdit.setText(t.getText());
        //아이디
        mCurrentId.setText(Long.toString(id));

        //수정,삭제 버튼 활성화
        setEnabled(true);
    }

    //검색된 내용 표시
    private void toastMemo(String str){
        if(str.length() == 0){
            //문서가 없을 때는 아무것도 하지 않는다.
            return;
        }

        //검색 실행
        String memo = dbAdapter.searchMemo(str);
        if(memo.length() == 0){
            return;
        }
        Toast.makeText(this, memo, Toast.LENGTH_SHORT).show();
    }

    //삭제, 수정 버튼 상태 변경
    private void setEnabled(boolean enabled){
        int buttons[] = {R.id.delete_button,R.id.modify_button};
        for(int id : buttons){
            Button button = (Button)findViewById(id);
            button.setEnabled(enabled);
        }
    }

}
