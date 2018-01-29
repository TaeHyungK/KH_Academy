package button2.o.mund.hola.mx.es.kr.android.viewpager2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_one, btn_two, btn_three;
    ViewPager mPager;
    int[] btn = {R.id.btn_one, R.id.btn_two, R.id.btn_three};

    private View.OnClickListener myListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_one:
                    mPager.setCurrentItem(0);
                    break;
                case R.id.btn_two:
                    mPager.setCurrentItem(1);
                    break;
                case R.id.btn_three:
                    mPager.setCurrentItem(2);
                    break;
                case R.id.btn_yellow:

                    break;
                case R.id.btn_sky:

                    break;
                case R.id.btn_green:
                    String text = ((Button) view).getText().toString();
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메뉴 버튼 이벤트 연결
        for(int id : btn){
            //이벤트 소스와 이벤트 리스너를 연결
            findViewById(id).setOnClickListener(myListner);
        }

        mPager = (ViewPager) findViewById(R.id.pager);
        //Adapter를 ViewPager에 등록
        mPager.setAdapter(new MyPagerAdapter(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //커스텀 페이저 어댑터 정의
    private class MyPagerAdapter extends PagerAdapter{

        LayoutInflater inflater;
        public MyPagerAdapter(Context context){
            inflater = LayoutInflater.from(context);
        }

        //현재 PagerAdapter에서 관리할 View의 갯수
        @Override
        public int getCount() {
            return btn.length;
        }

        //ViewPager에서 사용할 뷰 객체 생성/등록
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = null;
            switch(position){
                case 0:
                    v = inflater.inflate(R.layout.page_one,null);
                    v.findViewById(R.id.btn_yellow).setOnClickListener(myListner);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.page_two,null);
                    v.findViewById(R.id.btn_sky).setOnClickListener(myListner);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.page_three,null);
                    v.findViewById(R.id.btn_green).setOnClickListener(myListner);
                    break;
            }
            //생성된 뷰 객체 등록
            ((ViewPager)container).addView(v,0);

            return v;
        }

        //뷰 객체 삭제
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }

        //instantiateItem메소드에서 생성한 객체를 이용할 것인지 여부
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
