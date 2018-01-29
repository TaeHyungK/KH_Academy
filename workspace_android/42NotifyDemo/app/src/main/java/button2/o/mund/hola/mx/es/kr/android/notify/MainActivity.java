package button2.o.mund.hola.mx.es.kr.android.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    private static final int NOTIFY_ME_ID = 1337;
    private Timer timer = new Timer();
    private int count = 0;

    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.notify);
        btn2 = findViewById(R.id.cancel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerTask task = new TimerTask() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void run() {
                        notifyMe();
                    }
                };
                timer.schedule(task,5000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                mgr.cancel(NOTIFY_ME_ID);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void notifyMe(){
        //생성할 때 특별한 케이스
        //시스템에서 노티피케이션 서비스를 뽑아오는 형태
        NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //메시지를 클릭하면 이동할 페이지를 지정
        //메시지를 클릭하고 이동할 때는 Intent를 통해 이동한 Activity클래스를 지정하고
        //PendingIntent의 getActivity에 Intent를 등록함
        PendingIntent i = PendingIntent.getActivity(this,0, new Intent(getApplicationContext(),NotifyMessage.class), 0);

        String NOTIFICATION_CHANNEL_ID = "my_channel";
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);

        //채널 설정
        notificationChannel.setDescription("Channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
        notificationChannel.enableVibration(true);

        mgr.createNotificationChannel(notificationChannel);

        NotificationCompat.Builder note = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        note.setTicker("문자가 수신됨");
        note.setAutoCancel(true);
        note.setSmallIcon(R.drawable.red_ball);
        note.setNumber(++count);
        note.setContentTitle("메시지가 수신됨");
        note.setContentText(count + "번째 표시된 메시지 입니다.");
        note.setContentIntent(i);

        mgr.notify(NOTIFY_ME_ID, note.build());
    }

}
