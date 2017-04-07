package cn.hlq.sqlitestudy.db;

/**
 * Created by HLQ on 2017/4/7
 * 这里为了避免累赘，简单附上创建学生表的SQL语句，具体详情大家可直接查看Demo源码
 */

public class SQLManager {

    /**
     * 创建学生表
     */
    public static final String SQL_CREATE_TABLE_STU="create table if not exists stu (stu_id integer primary key autoincrement,stu_name varchar(15),stu_age integer,stu_address varchar(50))";

}
