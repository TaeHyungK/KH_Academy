package kr.android.list.custom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyItem> arItem;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arItem = new ArrayList<MyItem>();
        arItem.add(new MyItem(R.mipmap.ic_launcher, "삼성 갤럭시"));
        arItem.add(new MyItem(R.mipmap.ic_launcher, "LG 세탁기"));
        arItem.add(new MyItem(R.mipmap.ic_launcher, "대우 전자레인지"));


        //MyListAdapter 생성
        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.row_content, arItem);

        //ListView 호출
        listView = findViewById(R.id.list);
        //ListView에 어댑터 등록
        listView.setAdapter(myListAdapter);

    }
}

//리스트 뷰에 표시할 항목
class MyItem{
    int icon;
    String name;

    MyItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }
}

//커스텀 어댑터 클래스
class MyListAdapter extends BaseAdapter{

    Context context;
    ArrayList<MyItem> aList;
    int layout;
    LayoutInflater inflater;

    public MyListAdapter(Context context, int layout, ArrayList<MyItem> aList) {
        this.context = context;
        this.layout = layout;
        this.aList = aList;

        //LayoutInflater 객체 생성
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    @Override
    public Object getItem(int position) {
        return aList.get(position).name;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //ListView에 데이터를 표시
        final int pos = position;
        if (view == null) {
            view = inflater.inflate(R.layout.row_content, null);
        }

        //각각의 View에 데이터 매칭
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(aList.get(position).icon);

        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(aList.get(position).name);

        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = aList.get(pos).name + "을 주문합니다.";
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
