package button2.o.mund.hola.mx.es.kr.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class NewsService extends Service{
    boolean mQuit;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        NewsThread thread = new NewsThread();
        thread.start();

        return super.onStartCommand(intent,flags,startId);
    }


    //뉴스 데이터를 처리하는 Thread
    class NewsThread extends Thread{
        String[] arNews = {
                "일본, 독도는 한국땅으로 인정",
                "2018 동계올림픽에서 한국 1위 확정",
                "2018 월드컵에서 한국 최종 우승 확정",
                "2018 아시안 게임에서 한국 우승 확정",
                "한반도가 더 이상 지진 위험 지역이 아님",
                "가정용 로봇이 보편화됨",
                "국가에서 한달에 5백만원씩 무상지원"
        };

        @Override
        public void run(){
            for(int i=0;mQuit==false;i++){
                Message msg = new Message();

                Bundle bundle = new Bundle();
                                           //0~6만 루프돌도록 나머지연산자 사용
                bundle.putString("news",arNews[i%arNews.length]);
                msg.setData(bundle);
                
                mHandler.sendMessage(msg);
                
                try{
                    Thread.sleep(5000);
                }catch(Exception e){
                    
                }
            }
        }
    }

    //백그라운드 작업으로 생성된 데이터를 사용자 인터페이스에적용
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            String news = msg.getData().getString("news");
            Toast.makeText(NewsService.this, news, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroy(){
        super.onDestroy();

        Toast.makeText(this, "Service End", Toast.LENGTH_SHORT).show();
        //Thread의 작업 루프를 빠져나가기 위해서
        mQuit = true;
    }


}
