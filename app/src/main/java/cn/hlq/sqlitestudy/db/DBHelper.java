package cn.hlq.sqlitestudy.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HLQ on 2017/4/7
 * 创建数据库(初始化)帮助类
 * 现在创建一个学生表，表中含有编号，姓名，年龄，地址
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME="sqlite_study.db";
    /**
     * 数据库版本号
     */
    private static final int DATABASE_VERSION=1;

    /**
     * 初始化设置数据库名称，数据库版本号
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 键明其意，在创建的时候会调用，而且只会调用一次
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建学生表
        db.execSQL(SQLManager.SQL_CREATE_TABLE_STU);
    }

    /**
     * 数据库有更新时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
