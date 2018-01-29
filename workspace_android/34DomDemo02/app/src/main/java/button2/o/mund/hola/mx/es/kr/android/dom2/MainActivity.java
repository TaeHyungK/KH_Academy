package button2.o.mund.hola.mx.es.kr.android.dom2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.result);
        button = findViewById(R.id.parse);

        //이벤트 연결
        button.setOnClickListener(this);

    }

    //이벤트 핸들러
    @Override
    public void onClick(View view) {
        try{
            //raw 폴더의 product.xml을 읽어들여서 InputStream으로 반환
            InputStream in = getResources().openRawResource(R.raw.product);

            //DocumentBuilder 생성
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            //InputStream을 이용해서 Document 객체 생성
            Document doc = builder.parse(in);

            StringBuffer sb = new StringBuffer();
            //item 태그 정보를 NodeList로 반환
            NodeList items = doc.getElementsByTagName("item");

            sb.append("주문 항목\n");
            for(int i=0;i<items.getLength();i++){
                //item 태그의 내용(text)를 반환
                String itemName = items.item(i).getFirstChild().getNodeValue();
                sb.append((i+1) + " : " + itemName + "\n");
            }

            editText.setText(sb.toString());

            //자원 정리
            in.close();

        }catch(Exception e) {
            Toast.makeText(this, "예외: " + e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
