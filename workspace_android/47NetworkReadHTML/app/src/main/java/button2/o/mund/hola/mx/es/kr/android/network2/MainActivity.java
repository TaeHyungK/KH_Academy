package button2.o.mund.hola.mx.es.kr.android.network2;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NetworkReadHTML";
    private static final String ADDRESS = "https://m.daum.net";
    private EditText edit;
    private ProgressDialog dialog;
    private Button goButton;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.edit);

        goButton = (Button) findViewById(R.id.do_action);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ProgressDialog 실행
                dialog = ProgressDialog.show(MainActivity.this,"사이트 접속 중","페이지를 로드하는 중...", true);
                processData();
            }
        });
    }

    public void processData(){
        edit.setText("");//초기화
        new Thread() {
            @Override
            public void run() {
                final String str = getStringFromUrl();

                //백그라운드에서 작업한 데이터를 사용자 인터페이스에 적용
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        edit.setText(str);
                        //ProgressDialog 중지
                        dialog.dismiss();
                    }
                });
            }
        }.start();
    }

    //웹에서 데이터를 내려받음
    public String getStringFromUrl(){
        StringBuffer response = new StringBuffer();
        HttpURLConnection urlConnection = null;
        BufferedReader br = null;
        String line;
        try{
            URL url = new URL(ADDRESS);
            urlConnection = (HttpURLConnection)url.openConnection();

            br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
            while ((line = br.readLine()) != null){
                response.append(line);
                //줄바꿈
                response.append(System.getProperty("line.separator"));
            }
        }catch (MalformedURLException e){
            Log.e(TAG,e.toString());
        }catch (IOException e){
            Log.e(TAG,e.toString());
        }finally {
            if(br!=null)try{br.close();}catch (IOException e){}
        }
        return response.toString();
    }
}