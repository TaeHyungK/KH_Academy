package kr.android.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView textView;
    ListView listView;
    String[] items = {"서울","부산","대구","광주","서울","부산","대구","광주","서울","부산","대구","광주","서울","부산","대구","광주"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textView);
        //어댑터생성
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,items);
        //어탭터를 리스트에 등록
        listView.setAdapter(adapter);

        //이벤트 연결
        listView.setOnItemClickListener(this);
    }

    //이벤트 핸들러
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        textView.setText(items[position]);
    }


}
