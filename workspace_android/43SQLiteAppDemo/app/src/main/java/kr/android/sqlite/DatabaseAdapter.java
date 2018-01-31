package kr.android.sqlite;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {
    //-------------------상수정의 시작--------//
    //Log 처리를 위한 TAG 지정
    static final String TAG = "DatabaseAdapter";
    //데이터베이스 파일 이름
    static final String DB_NAME = "daily_memo.db";
    //테이블 이름
    static final String TABLE_NAME = "memo";
    //컬럼 이름
    static final String MEMO_ID = "_id";
    static final String MEMO_CONTENT = "content";
    //컬럼 인덱스
    static final int ID_INDEX = 0;
    static final int CONTENT_INDEX = 1;
    //컬럼 명세
    static final String[] PROJECTION = new String[]{MEMO_ID,MEMO_CONTENT};
    //테이블 생성 SQL
    static final String CREATE_TABLE ="CREATE table " + TABLE_NAME + "(" + MEMO_ID + " integer primary key autoincrement, " + MEMO_CONTENT + " text not null)";

    //테이블 삭제 SQL
    static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    //-------------------상수정의 끝--------//(+

    //데이터베이스 연동 객체
    private SQLiteDatabase db;
    //데이터베이스를 이용하는 어플리케이션의 컨텍스트
    private Context context;

    public DatabaseAdapter(Context context){
        this.context = context;
    }

    //SQLiteDatabase 생성
    public void open() throws SQLException {
        try{
            //읽고 쓸 수 있게 데이터베이스에 접근
            db = (new DatabaseHelper(context)).getWritableDatabase();
        }catch (SQLException e){
            //읽기 전용으로 데이터베이스에 접근
            db = (new DatabaseHelper(context)).getReadableDatabase();
        }
    }

    //SQLiteDatabase 자원정리
    public void close(){
        if(db!=null){
            db.close();
        }
    }

    //목록
    public Cursor fetchAllMemo(){
        return db.query(TABLE_NAME,//테이블명
                            PROJECTION,//컬럼명세(_id,content
                            null,//where절
                            null,//where절에 전달될 데이터
                            null,//group by
                            null,//having
                            MEMO_ID+" DESC" //order by
                        ) ;
    }

    //검색
    public String searchMemo(String str) {
        //읽을 데이터의 조건
        String where = MEMO_CONTENT + " like ?";
        //where의 ?에 전달할 데이터
        String param = str.substring(0, 1) + "%";
        //검색
        Cursor c = db.query(TABLE_NAME, //테이블명
                PROJECTION, //컬럼명세
                where, //where절
                new String[]{param}, //where절 전달할 데이터
                null, //group by
                null, //having
                MEMO_ID + " DESC", // order by
                "10" // limit 최대 10개
        );
        StringBuffer buff = new StringBuffer();
        if (c.moveToFirst()) {
            //검색 결과를 차례로 꺼내 문자열에 추가
            do {
                buff.append("id(");
                buff.append(c.getLong(ID_INDEX));
                buff.append(")");
                buff.append(c.getString(CONTENT_INDEX));
                buff.append("\n");

            } while (c.moveToNext());
        }

        //Cursor를 닫음
        c.close();
        return buff.toString();
    }

    //등록
    public String addMemo(String content){
        ContentValues values = new ContentValues();
        values.put(MEMO_CONTENT,content);
                            //테이블명,     컬럼명,    ContentValues
        long id = db.insert(TABLE_NAME,MEMO_CONTENT,values);
        return Long.toString(id);
    }

    //수정
    public void  setMemo(String id, String content){
        //업데이트 값 설정
        ContentValues values = new ContentValues();
        values.put(MEMO_CONTENT,content);

        //행을 업데이트
        db.update(TABLE_NAME, //테이블 명
                    values, //수정할 데이터
                    MEMO_ID+" = ? ",//where절
                    new String[]{id}//where절의 ?에 전달할 primary key
                );

    }

    //삭제
    public void deleteMemo(String id){
        db.delete(TABLE_NAME,MEMO_ID+" = ? ", //where절
                    new String[]{id} //where절의 ?에 전달할 데이터
                     );

    }

    //SQLiteOpenHelper를 상속받아 구현한 클래스
    public class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){
            super(context,DB_NAME,null,1);
        }

        //데이터베이스를 새로 만든 다음 호출
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //내부에 테이블 만들기
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        //데이터베이스를 사용 중에 스키마 버전을 변경하면 호출
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            //데이터베이스의스키마 버전을 변경한다는 것은 데이터베이스으 구조를 변경하고자 한다는 것을 의미.
            //예를 들어 테이블을 수정하고자 하면 수정 작업, 테이블을 삭제하고자 하면 삭제작업

            //기본값을 테이블 삭제(상황에 따라 변경할 것)
            sqLiteDatabase.execSQL(DROP_TABLE);
            //새로운 테이블로 다시 생성
            onCreate(sqLiteDatabase);
        }
    }


}
