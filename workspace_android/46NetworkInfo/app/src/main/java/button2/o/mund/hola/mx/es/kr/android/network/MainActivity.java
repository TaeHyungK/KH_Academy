package button2.o.mund.hola.mx.es.kr.android.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //롤리팝(API 21)이상 버전을 가지는 핸드폰인지?
            //위와 같이 버전 체크하지 않을 경우 minSDKVersion은 꼭 21로 변경해야 함
            Network[] networks = cm.getAllNetworks();
            NetworkInfo networkInfo;
            for(Network mNetwork : networks){
                networkInfo = cm.getNetworkInfo(mNetwork);
                textView.append("typeName: " + networkInfo.getTypeName() + "\n");
                textView.append("available: " + networkInfo.isAvailable() + "\n");
                textView.append("connected: " + networkInfo.isConnected() + "\n");
                textView.append("\n");
            }
        }else{
            //API 21버전 미만의 핸드폰
            NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

            for (NetworkInfo networkInfo : networkInfos) {
                textView.append("typeName: " + networkInfo.getTypeName() + "\n");
                textView.append("available: " + networkInfo.isAvailable() + "\n");
                textView.append("connected: " + networkInfo.isConnected() + "\n");
                textView.append("\n");
            }
        }

    }
}
