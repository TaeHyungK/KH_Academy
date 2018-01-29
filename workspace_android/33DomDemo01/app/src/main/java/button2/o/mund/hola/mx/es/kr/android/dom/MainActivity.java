package button2.o.mund.hola.mx.es.kr.android.dom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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

            InputStream in = getResources().openRawResource(R.raw.words);

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            //inputstream을 읽어들여 document 객체 반환
            Document doc = builder.parse(in);
            NodeList words = doc.getElementsByTagName("word");

            for(int i=0; i<words.getLength();i++) {
                items.add(((Element) words.item(i)).getAttribute("value"));
            }

        }catch(Exception e){
            Toast.makeText(this, "예외: "+ e.toString(), Toast.LENGTH_SHORT).show();
        }

        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        textView.setText(items.get(position));
    }
}
