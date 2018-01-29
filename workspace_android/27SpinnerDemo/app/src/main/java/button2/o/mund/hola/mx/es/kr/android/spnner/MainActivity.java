package button2.o.mund.hola.mx.es.kr.android.spnner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView textView;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    String[] items= {"대한민국", "미국", "중국","일본", "러시아","영국"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        //ArrayAdapter 생성
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, items);
        //드롭다운 화면에 표시할 리소스 지정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //ArrayAdapter를 Spinner에 등록
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        textView.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        textView.setText("");
    }
}
