package button2.o.mund.hola.mx.es.kr.android.notify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user1 on 2018-01-26.
 */

public class NotifyMessage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("알림메시지!");

        //생성된 view를 메인 액티비티에 등록
        setContentView(text);

    }
}
