package button2.o.mund.hola.mx.es.kr.android.json;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        //assets 폴더 접근
        AssetManager assetManager = getResources().getAssets();

        BufferedReader br = null;

        try{
            //사용하고자 하는 json 파일 오픈
            AssetManager.AssetInputStream ais = (AssetManager.AssetInputStream) assetManager.open("sample.json");
            br = new BufferedReader(new InputStreamReader(ais, "UTF-8"));

            StringBuffer sb = new StringBuffer();
            String result = null;

            while ((result = br.readLine()) != null) {
                sb.append(result);
            }

            //StringBuffer에 저장된 문자열을 사용해서 JSON 객체 생성
            JSONObject jsonObject = new JSONObject(sb.toString());

            // menu의 value를 호출
            String menu = jsonObject.getString("menu");
            textView.setText(menu + "\n");

            //member의 value를 호출, 배열로 반환
            JSONArray jsonArray =  new JSONArray(jsonObject.getString("member"));

            for (int i=0;i<jsonArray.length(); i++) {
                textView.append("-------------\n");
                textView.append(jsonArray.getJSONObject(i).getString("id") + ", ");
                textView.append(jsonArray.getJSONObject(i).getString("name") + ", ");
                textView.append(jsonArray.getJSONObject(i).getString("address") + ", ");
                textView.append(jsonArray.getJSONObject(i).getString("job") + "\n");
            }

        }catch(Exception e){
            Log.e("ReadJSONDemo", e.toString());
        }finally{
            if(br != null) try{br.close();} catch(IOException e){}
        }


    }
}
