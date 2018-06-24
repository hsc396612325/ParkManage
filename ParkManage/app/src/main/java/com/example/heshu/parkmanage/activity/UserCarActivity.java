package com.example.heshu.parkmanage.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.adapter.ParkRecyclerViewAdapter;
import com.example.heshu.parkmanage.adapter.UserCarAdapter;
import com.example.heshu.parkmanage.bean.CarBean;

import java.util.ArrayList;
import java.util.List;

public class UserCarActivity extends AppCompatActivity {

    List<CarBean> mCarBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_car);

        initData();
        initView();

    }

    private void initData() {
        mCarBeanList = new ArrayList<>();

        CarBean carBean = new CarBean();
        carBean.setCarColor("白");
        carBean.setCarPlateNumber("陕E MR100");
        carBean.setCarTrademark("宝马");
        carBean.setCarName("车辆1");
        mCarBeanList.add(carBean);

        CarBean carBean2 = new CarBean();
        carBean2.setCarColor("黑");
        carBean2.setCarPlateNumber("陕E MR110");
        carBean2.setCarTrademark("宝马");
        carBean2.setCarName("车辆2");
        mCarBeanList.add(carBean2);

        CarBean carBean3 = new CarBean();
        carBean3.setCarColor("红");
        carBean3.setCarPlateNumber("陕E M0100");
        carBean3.setCarTrademark("桑塔纳");
        carBean3.setCarName("车辆3");
        mCarBeanList.add(carBean3);

        CarBean carBean4 = new CarBean();
        carBean4.setCarColor("白");
        carBean4.setCarPlateNumber("陕E MR133");
        carBean4.setCarTrademark("五菱宏光");
        carBean4.setCarName("车辆4");
        mCarBeanList.add(carBean);
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("我的车辆");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.park_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserCarAdapter adapter = new UserCarAdapter(mCarBeanList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_car, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.add:
                Intent intent = new Intent(UserCarActivity.this,AddUserCarActivity.class);
                startActivity(intent);
                return true;


            default:    // 如果用户的行为没有被执行，则会调用父类的方法去处理，建议保留。
                return super.onOptionsItemSelected(item);
        }


    }
}
