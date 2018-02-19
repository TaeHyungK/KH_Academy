package button2.o.mund.hola.mx.es.kr.android.scroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    ImageView big_img;

    int[] imageItems = new int[]{
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.image03,
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.image03,
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.image03,
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.image03
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        big_img = findViewById(R.id.big_img);

        //ImageView 생성해서 LinearLayout에 등록
        for(int i=0;i<imageItems.length;i++) {
            final int index = i;
            ImageView image = new ImageView(this);
            image.setImageResource(imageItems[i]);
            image.setLayoutParams(new ViewGroup.LayoutParams(100,140));
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            image.setPadding(5,5,5,5);

            //생성된 ImageView를 LinearLayout에 등록
            layout.addView(image);

            //이벤트 연결
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //작은 이미지를 클릭하면 큰 이미지가 보여지게 처리
                    big_img.setImageResource(imageItems[index]);
                }
            });
        }

    }
}
