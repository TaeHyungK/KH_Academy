package button2.o.mund.hola.mx.es.kr.android.network3;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "NetworkReadImage";
    private static final String IMAGE_URL = "http://sstatic.naver.net/search/img3/h1_naver.gif";

    ImageView imageView;
    ProgressDialog dialog;
    Button goButton;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        goButton = findViewById(R.id.do_action);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(MainActivity.this, "사이트 접속 중", "이미지 로드중...", true);
                processData();
            }
        });
    }

    public void processData(){
        new Thread(){
            @Override
            public void run() {
                final Bitmap img = getRemoteImage();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(img);
                        dialog.dismiss();
                    }
                });
            }
        }.start();
    }

    private Bitmap getRemoteImage(){
        Bitmap bitmap = null;
        BufferedInputStream bis = null;
        HttpURLConnection urlConnection = null;

        try{
            URL url = new URL(IMAGE_URL);
            urlConnection = (HttpURLConnection)url.openConnection();

            bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());

        }catch(MalformedURLException e){
            Log.e(TAG, e.toString());
        }catch(IOException e){
            Log.e(TAG, e.toString());
        }finally{

        }

        return bitmap;
    }

}
