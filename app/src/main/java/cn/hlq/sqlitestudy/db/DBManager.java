package cn.hlq.sqlitestudy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.hlq.sqlitestudy.entity.Student;

/**
 * Created by HLQ on 2017/4/7
 */

public class DBManager {

    private Context context;
    private DBHelper helper;
    private SQLiteDatabase db;

    /**
     * 构造方法初始化
     *
     * @param context
     */
    public DBManager(Context context) {
        this.context = context;
        this.helper = new DBHelper(context);
        this.db = helper.getWritableDatabase();
    }

    /**
     * 新增一条数据
     *
     * @param stu
     * @return
     */
    public long insertDB(Student stu) {
        ContentValues values = new ContentValues();
        values.put("stu_name", stu.getStuName());
        values.put("stu_age", stu.getStuAge());
        values.put("stu_address", stu.getStuAddress());
        long rowsNum = 0;
        try {
            rowsNum = db.insert("stu", null, values);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HLQ_Struggle", "insert error:" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return rowsNum;
    }

    /**
     * 删除单条数据
     *
     * @param stuName
     * @return
     */
    public int deleteDB(String stuName) {
        int rowsNum = 0;
        try {
            rowsNum = db.delete("stu", "stu_name=?", new String[]{stuName});
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HLQ_Struggle", "delete error:" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return rowsNum;
    }

    /**
     * 删除多条数据
     *
     * @param stuName
     * @param stuAge
     * @return
     */
    public int deleteDBForWhere(String stuName, int stuAge) {
        int rowsNum = 0;
        try {
            rowsNum = db.delete("stu", "stu_name=? and stu_age=?", new String[]{stuName, stuAge + ""});
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HLQ_Struggle", "delete more where error:" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return rowsNum;
    }

    /**
     * 根据姓名修改
     *
     * @param stuName
     * @return
     */
    public int updateDB(String stuName) {
        ContentValues values = new ContentValues();
        values.put("stu_name", "Test");
        int rowsNum = 0;
        try {
            rowsNum = db.update("stu", values, "stu_name=?", new String[]{stuName});
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HLQ_Struggle", "update error:" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return rowsNum;
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Student> queryStu() {
        List<Student> stuList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = db.query("stu", null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    Student stu = new Student();
                    stu.setStuName(cursor.getString(cursor.getColumnIndex("stu_name")));
                    stu.setStuAge(cursor.getInt(cursor.getColumnIndex("stu_age")));
                    stu.setStuAddress(cursor.getString(cursor.getColumnIndex("stu_address")));
                    stuList.add(stu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HLQ_Struggle", "query error:" + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return stuList;
    }

}
