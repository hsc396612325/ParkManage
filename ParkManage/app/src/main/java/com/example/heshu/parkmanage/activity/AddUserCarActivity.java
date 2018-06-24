package com.example.heshu.parkmanage.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.adapter.UserCarAdapter;

public class AddUserCarActivity extends AppCompatActivity {
    private EditText mCarName;
    private EditText mCarPlateNumber;
    private EditText mCarColor;
    private EditText mCarTrademark;
    private Button mRefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_car);

        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新增车辆");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mCarName = findViewById(R.id.car_name);
        mCarPlateNumber = findViewById(R.id.user_car_plate_number);
        mCarColor = findViewById(R.id.user_car_color);
        mCarTrademark = findViewById(R.id.user_car_trademark);
        mRefer = findViewById(R.id.refer);

        mRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:    // 如果用户的行为没有被执行，则会调用父类的方法去处理，建议保留。
                return super.onOptionsItemSelected(item);

        }
    }
}
