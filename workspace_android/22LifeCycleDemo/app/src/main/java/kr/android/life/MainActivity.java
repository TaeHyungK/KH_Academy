package kr.android.life;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.i(TAG, "onCreate: 실행");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 실행");
    }

}
