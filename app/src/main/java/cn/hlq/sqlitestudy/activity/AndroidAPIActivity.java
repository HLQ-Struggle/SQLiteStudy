package cn.hlq.sqlitestudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.hlq.sqlitestudy.R;
import cn.hlq.sqlitestudy.db.DBManager;
import cn.hlq.sqlitestudy.entity.Student;

/**
 * create by heliquan at 2017年4月7日
 */
public class AndroidAPIActivity extends Activity implements View.OnClickListener {

    private Button btnInsert, btnDelete, btnWhereDelete, btnUpdate, btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_api);
        initView();
    }

    private void initView() {
        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnWhereDelete = (Button) findViewById(R.id.btn_delete_where);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnQuery = (Button) findViewById(R.id.btn_query);

        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnWhereDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                //测试多条件删除
                new DBManager(AndroidAPIActivity.this).insertDB(new Student("李四", 19, "河南"));
                long insertRowsNum = new DBManager(AndroidAPIActivity.this).insertDB(new Student("张三", 18, "北京市"));
                if (insertRowsNum > 0) {
                    Toast.makeText(AndroidAPIActivity.this, "新增成功，返回结果为：" + insertRowsNum, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AndroidAPIActivity.this, "新增失败，返回结果为：" + insertRowsNum, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_delete:
                int deleteRowsNum = new DBManager(AndroidAPIActivity.this).deleteDB("张三");
                if (deleteRowsNum >= 0) {
                    Toast.makeText(AndroidAPIActivity.this, "删除成功，返回结果为：" + deleteRowsNum, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_delete_where:
                int deleteWhereRowsNum = new DBManager(AndroidAPIActivity.this).deleteDBForWhere("李四", 19);
                if (deleteWhereRowsNum >= 0) {
                    Toast.makeText(AndroidAPIActivity.this, "删除成功，返回结果为：" + deleteWhereRowsNum, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_update:
                int updateRowsNum = new DBManager(AndroidAPIActivity.this).updateDB("张三");
                if (updateRowsNum >= 0) {
                    Toast.makeText(AndroidAPIActivity.this, "更新成功，返回结果为：" + updateRowsNum, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AndroidAPIActivity.this, "更新失败，返回结果为：" + updateRowsNum, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_query:
                List<Student> studentList = new DBManager(AndroidAPIActivity.this).queryStu();
                Toast.makeText(AndroidAPIActivity.this, studentList.get(0).getStuName() + "  " + studentList.get(0).getStuAge() + "  " + studentList.get(0).getStuAddress(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
