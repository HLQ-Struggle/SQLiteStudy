package cn.hlq.sqlitestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.hlq.sqlitestudy.activity.AndroidAPIActivity;
import cn.hlq.sqlitestudy.activity.SQLActivity;

/**
 * Create by heliquan at 2017年4月7日
 */
public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAPI, btnSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnAPI = (Button) findViewById(R.id.btn_api);
        btnSQL = (Button) findViewById(R.id.btn_sql);

        btnAPI.setOnClickListener(this);
        btnSQL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_api:
                startActivity(new Intent(MainActivity.this, AndroidAPIActivity.class));
                break;

            case R.id.btn_sql:
                startActivity(new Intent(MainActivity.this, SQLActivity.class));
                break;
        }
    }
}
