package kr.android.weather;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    //기상청 날씨 정보
    private static final String WEATHER_URL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
    private WebView webView;
    private List<Forecast> list = new ArrayList<Forecast>();
    private ProgressBar progress;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        progress = (ProgressBar)findViewById(R.id.progressBar);

        updateForecast();
    }

    //백그라운드에서 작업한 데이터를 사용자 인터페이스에 적용
    private void updateForecast(){
        //ProgressBar 노출
        progress.setVisibility(View.VISIBLE);

        new Thread(){
            @Override
            public void run(){
                //웹에서 XML을 내려받아서 파싱해서 데이터를 ArrayList에 저장
                //buildForecastByDOM(getStreamFromUrl());
                buildForecastByXmlPullParser(getStreamFromUrl());

                //백그라운드에서 작업한 데이터를 사용자 인터페이스에 반영
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        String page = generatePage();
                        //생성한 HTML을 WebView에 표시
                        webView.loadDataWithBaseURL(null,page,"text/html","UTF-8",null);
                        //ProgressBar 감추기
                        progress.setVisibility(View.GONE);
                    }
                });
            }
        }.start();
    }

    //xml을 읽어들여 InputStream으로 반환
    private InputStream getStreamFromUrl(){
        InputStream input = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(WEATHER_URL);
            urlConnection = (HttpURLConnection)url.openConnection();

            input = urlConnection.getInputStream();

        }catch (Exception e){
            Log.e("NetworkWeatherDemo",e.toString());
        }
        return input;
    }

    //InputStream을 전달 받아서 DOM 파서를 이용해서 파싱
    public void buildForecastByDOM(InputStream input){
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(input);
            NodeList locals = doc.getElementsByTagName("local");

            for(int i=0;i<locals.getLength();i++){
                Element local = (Element)locals.item(i);

                //한 건의 데이터(도시, 날씨, 온도)를 저장할 객체 생성
                Forecast forecast = new Forecast();

                //도시명
                forecast.local = local.getFirstChild().getNodeValue();
                //날씨
                forecast.desc = local.getAttribute("desc");
                //온도
                forecast.temp = local.getAttribute("ta");

                //Forecast를 ArrayList에 저장
                list.add(forecast);
            }
        }catch(Exception e){
            Log.e("NetworkWeatherDemo",e.toString());
        }
    }

    //InputStream을 XmlPullParser로 파싱해서 데이터를 ArrayList에 저장
    public void buildForecastByXmlPullParser(InputStream input){
        String local = null;
        String desc = null;
        String temp = null;

        try{
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();

            //파서에 스트림 연결
            parser.setInput(input,"UTF-8");

            while(parser.getEventType()!=XmlPullParser.END_DOCUMENT){
                if(parser.getEventType()==XmlPullParser.START_TAG){
                    if(parser.getName().equals("local")){
                        //날씨
                        desc = parser.getAttributeValue(2);
                        //온도(온도가 미표시된 경우가 있어서 조건체크 필수
                        //
                        // )
                        if(parser.getAttributeCount()>3){
                            temp = parser.getAttributeValue(3);
                        }else{
                            temp = "";
                        }

                    }
                }else if(parser.getEventType()==XmlPullParser.TEXT){
                    //도시명
                    local = parser.getText();
                }else if(parser.getEventType()==XmlPullParser.END_TAG){
                    if(parser.getName().equals("local")){
                        list.add(new Forecast(local, desc, temp));
                    }
                }
                //커서를 다음 태그로 이동
                parser.next();
            }
        }catch (Exception e){
            Log.e("NetworkWeatherDemo",e.toString());
        }
    }

    public String generatePage(){
        StringBuffer sb = new StringBuffer("<html><body><table style=\"width:100%;\">");

        sb.append("<tr><th width=\"30%\">지역</th><th width=\"50%\">날씨</th><th width=\"20%\">온도</th></tr>");

        for(Forecast forecast : list){
            sb.append("<tr><td align=\"center\">");
            sb.append(forecast.local);
            sb.append("</td><td align=\"center\">");
            sb.append(forecast.desc);
            sb.append("</td><td>");
            sb.append(forecast.temp);
            sb.append("</td></tr>");
        }
        sb.append("</table></body></html>");



        return sb.toString();
    }

    //한 건의 날씨 정보를 저장하는 클래스
    class Forecast{
        String local;
        String desc;
        String temp;

    public Forecast(){}

    public Forecast(String local, String desc, String temp){
        this.local = local;
        this.desc = desc;
        this.temp = temp;
    }
    }

}
