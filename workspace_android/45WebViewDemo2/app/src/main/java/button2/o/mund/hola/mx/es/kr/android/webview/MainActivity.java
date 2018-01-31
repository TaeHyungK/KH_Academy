package button2.o.mund.hola.mx.es.kr.android.webview;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        //링크에 대한 이벤트 연결
        webView.setWebViewClient(new MyWebClient());

        WebSettings set = webView.getSettings();
        //자바스크립트 사용
        set.setJavaScriptEnabled(true);
        //줌 기능 사용
        set.setBuiltInZoomControls(true);
        //시작 페이지 지정
        webView.loadUrl("https://m.naver.com");

    }

    //페이지 이동 및 종료 처리


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //화면 히스토리를 읽어들여 이전 페이지가 존재하는지 확인
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
        }else if(keyCode == KeyEvent.KEYCODE_BACK && !webView.canGoBack()){
            new AlertDialog.Builder(this)
                           .setTitle("종료 확인")
                           .setMessage("종료하시겠습니까?")
                           .setPositiveButton("예", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialogInterface, int i) {
                                   //Activity 종료
                                   finish();
                               }
                           })
                           .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialogInterface, int i) {

                               }
                           })
                           .show();
        }

        return true;
    }

    class MyWebClient extends WebViewClient{
        //N버전에서만 아래 메소드 동작하게 하면 minSdkVersion은 15로 유지할 수 있음
        @TargetApi(Build.VERSION_CODES.N) //N버전에서만 동작하게끔 하는 API
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            view.loadUrl(url);

            return true;
        }

        //하위 버전에서는 아래와 같이 명시함.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

    }
}
