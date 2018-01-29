package kr.android.list2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText edit;
    Button btn;
    ArrayList<String> todoItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        edit = (EditText)findViewById(R.id.edit);
        btn = (Button)findViewById(R.id.btn);

        //ArrayList생성
        todoItems = new ArrayList<String>();
        //ArrayAdapter 생성
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);

        //ArrayAdapter를 ListView에 등록
        listView.setAdapter(adapter);

        //이벤트 연결
        btn.setOnClickListener(new View.OnClickListener() {
            //이벤트 핸들러
            @Override
            public void onClick(View view) {
              String text = edit.getText().toString();
              if(text.length()>0){
                  //ArrayList에 데이터 저장, 최신 데이터가 가장
                  //위에 보여지게 하기위해 인덱스 0으로 지정
                  todoItems.add(0,text);
                  //데이터의 변경 내용을 ListView에 반영
                  adapter.notifyDataSetChanged();
                  //EditText초기화
                  edit.setText("");
              }else{
                  Toast.makeText(MainActivity.this,"일정을 입력하세요!",Toast.LENGTH_SHORT).show();
              }
            }
        });

    }
}
