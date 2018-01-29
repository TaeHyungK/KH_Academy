package button2.o.mund.hola.mx.es.kr.android.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private final static String NOTES = "notes.txt";
    private EditText editor;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editor = findViewById(R.id.editor);
        button = findViewById(R.id.close);

        //이벤트 연결
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity 종료
                finish();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        BufferedReader reader = null;
        try{
            //내장 영역에서파일을 읽어 옴
            InputStream in = openFileInput(NOTES);
            if(in != null){
                //바이트스트림을 문자스트림으로 가공
                reader = new BufferedReader(new InputStreamReader(in));
                String str;
                StringBuffer buf = new StringBuffer();

                while((str = reader.readLine()) != null){
                    buf.append(str + "\n");
                }
                //내장영역에 저장된 파일을 읽어들여 데이터를 EditText에 표시
                editor.setText(buf.toString());

            }
        }catch(FileNotFoundException e){
            //처음호출시는 파일이 존재하지 않아서 예외가 발생하지만 다시 호출시부터는
            //파일이 존재하기 때문에 프로그램 중단을 방지하기 위해 catch블럭을 사용함
        }catch(Exception e){
            Toast.makeText(this, "예외" + e.toString(), Toast.LENGTH_SHORT).show();
        }finally {
            if(reader != null) try{reader.close();} catch(IOException e) {}
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        //파일에 작성된 데이터를 저장
        OutputStreamWriter out = null;
        try{
            //MODE_PRIVATE : 덮어쓰기
            //MODE_APPEND : 이어쓰기
            out = new OutputStreamWriter(openFileOutput(NOTES,MODE_PRIVATE));

            out.write(editor.getText().toString());
            Toast.makeText(this, "데이터를 저장합니다.", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this, "예외" + e.toString(), Toast.LENGTH_SHORT).show();
        }finally{
            //파일 엑세스시, DB 연동시, 웹에있는 자료를 스트림으로 받는 경우
            //웬만하면 자원정리를 해주는 것이 좋음
            if(out != null) try{out.close();} catch(IOException e){}
        }
    }
}
