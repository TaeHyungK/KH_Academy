package button2.o.mund.hola.mx.es.kr.android.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user1 on 2018-01-29.
 */

public class DatabaseAdapter {
    //---------상수정의 시작---------//
    //Log 처리를 위한 TAG지정
    static final String TAG = "DatabaseAdapter";
    //데이터베이스 파일 이름
    static final String DB_NAME = "daily_memo.db";
    //테이블 이름
    static final String TABLE_NAME = "memo";
    //컬럼 이름
    static final String MEMO_ID = "_id";
    static final String MEMO_CONTENT = "content";
    //컬럼 인덱스
    static final int ID_INDEX=0;
    static final int CONTENT_INDEX=1;
    //컬럼 명세
    static final String[] PROJECTION = new String[]{MEMO_ID, MEMO_CONTENT};
    //테이블 생성 SQL
    static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" + MEMO_ID + " integer primary key autoincrement, " +
            MEMO_CONTENT + " text not null)";

    //테이블 삭제 SQL
    static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    //----------상수정의 끝---------//

    //데이터베이스 연동 객체
    private SQLiteDatabase db;
    //데이터베이스를 이용하는 어플리케이션 컨텍스트
    private Context context;

    public DatabaseAdapter(Context context) {
        this.context= context;
    }

    //SQLiteDatabse 생성
    public void open() throws SQLException{
        try {
            //읽고 쓸 수 있게 데이터베이스에 접근
            db = (new DatabaseHelper(context)).getWritableDatabase();

        } catch (SQLiteException e) {
            //읽기 전용으로 데이터베이스에 접근(쓸 수 없는 상황이 되면 읽을 수라도 있게!)
            db = (new DatabaseHelper(context)).getReadableDatabase();
        }

    }

    //목록
    public Cursor fetchAllMemo(){
        return null;
    }
    //검색
    public String searchMemo(String str){
        return null;
    }
    //등록
    public String addMemo(String content){
        return null;
    }
    //수정
    public void setMemo(String id, String content){

    }
    //삭제
    public void deleteMemo(String id) {

    }

    //SQLiteDatabase 자원 정리
    public void close(){
        if (db != null) {
            db.close();
        }
    }

    //SQLiteOpenHelper를 상속받아 구현한 클래스
    public class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){
            super(context, DB_NAME, null, 1);
        }

        //데이터베이스를 새로 만든 다음 호출
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //내부에 테이블 만들기
            db.execSQL(CREATE_TABLE);
        }

        //데이터베이스를 사용 중에 스키마 버전을 변경하면 호출되는 메소드
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            //데이터베이스의 스키마 버전을 변경한다는 것은 데이터베이스의 구조를 변경하고자 한다는 것을 의미함.
            //예를 들어, 테이블블을 수정하고자하면 수정작업.
            //테이블을 삭제하고자하면 삭제작업

            //기본값을 테이블 삭제(상황에 따라 변경할 것)
            db.execSQL(DROP_TABLE);
            //삭제 후 새로운 테이블로 다시 생성
            onCreate(db);
        }
    }

}
