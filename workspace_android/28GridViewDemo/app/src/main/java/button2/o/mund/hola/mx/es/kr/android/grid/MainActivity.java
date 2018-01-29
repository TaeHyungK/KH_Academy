package button2.o.mund.hola.mx.es.kr.android.grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView textView;
    GridView gridView;
    ArrayAdapter<String> adapter;
    String[] items ={"사과", "바나나","망고", "멜론", "수박","사과", "바나나","망고", "멜론", "수박","사과", "바나나","망고", "멜론", "수박","사과", "바나나","망고", "멜론", "수박","사과", "바나나","망고", "멜론", "수박","사과", "바나나","망고", "멜론", "수박"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        gridView = findViewById(R.id.gridView);

        //이벤트 연결
        gridView.setOnItemClickListener(this);
        //ArrayAdapter 생성
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);

        //ArrayAdpater를 GridView에 등록
        gridView.setAdapter(adapter);
    }

    //이벤트 핸들러
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        textView.setText(items[position]);
    }
}
