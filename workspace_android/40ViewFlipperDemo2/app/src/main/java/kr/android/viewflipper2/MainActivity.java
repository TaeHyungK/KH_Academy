package kr.android.viewflipper2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    ViewFlipper flipper;

    //터치 이벤트 발생 지점의 x좌표 저정
    float down_x;
    float up_x;
    private int[] imageItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageItems = new int[]{R.drawable.image01,R.drawable.image02,R.drawable.image03};

        flipper = (ViewFlipper)findViewById(R.id.flipper);

        for(int i : imageItems){
            ImageView image = new ImageView(this);
            image.setImageResource(i);
            flipper.addView(image,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }

        //이벤트 연결
        flipper.setOnTouchListener(this);

    }
    //이벤트 핸들러
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        //터치 이벤트가 일어난 뷰가 ViewFlipper가 아니면 return
        if(view != flipper) return false;

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            //터리 시작지점 x좌표 저장
            down_x = motionEvent.getX();
        }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            //터치 끝나는 지점 x좌표 저장
            up_x = motionEvent.getX();

            if(up_x < down_x){
                //터치할 때 왼쪽 방향으로 진행
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_out));

                flipper.showNext();

            }else if(up_x > down_x){
                //터치할 때 오른쪽 방향으로 진행
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_out));

                flipper.showPrevious();
            }
        }
        return true;
    }
}


















