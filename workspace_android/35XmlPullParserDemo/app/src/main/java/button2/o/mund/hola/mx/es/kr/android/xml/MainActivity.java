package button2.o.mund.hola.mx.es.kr.android.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView textView;
    ListView list;
    ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        list = findViewById(R.id.list);

        list.setOnItemClickListener(this);

        try{
            //words.xml 파일을 읽어서 XmlPullParser 객체 생성
            XmlPullParser xpp = getResources().getXml(R.xml.words);
            //              문서의 끝인지를 체크
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType() == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("word")) {
                        //word 태그의 속성 값을 반환해서 ArrayList에 저장
                        items.add(xpp.getAttributeValue(0));
                    }
                }
                xpp.next();
            }
        }catch(Exception e){
            Toast.makeText(this, "예외 : " + e.toString(), Toast.LENGTH_SHORT).show();
        }

        //ArrayAdapter를 생성해서 ListView에 등록
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

    }

    //이벤트 핸들러
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        textView.setText(items.get(position));
    }
}
