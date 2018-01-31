package kr.android.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        //1.URL 링크
//        webView.loadUrl("https://m.naver.com");

        //2. 태그를 호출
//        String msg = "<html><head><meta charset=\"UTF-8\"></head><body>Hello World! 안녕하세요!</body></html>";
//        webView.loadDataWithBaseURL(null, msg, "text/html", "UTF-8", null);

        //3. 내장 되어 있는 HTML을 읽어서 WebView에 표시하기
        webView.loadUrl("file:///android_asset/hello.html");

        //자바스크립트 사용 허용
        webView.getSettings().setJavaScriptEnabled(true);

        //자바스크립트 alert메소드 호출시 이벤트 연결
        MyWebChromeClient myWebChromeClient = new MyWebChromeClient();
        webView.setWebChromeClient(myWebChromeClient);
    }

    //자바스크립트 alert 메소드에 매핑된 클래스
    private class MyWebChromeClient extends WebChromeClient{
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            result.confirm();

            return true;
        }
    }
}
