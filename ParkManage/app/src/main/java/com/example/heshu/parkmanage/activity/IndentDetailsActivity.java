package com.example.heshu.parkmanage.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.bean.IndentBean;
import com.example.heshu.parkmanage.bean.ParkBean;
import com.example.heshu.parkmanage.util.App;

import org.w3c.dom.Text;

public class IndentDetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;

    private ImageView mImageView;

    private TextView mParkName;
    private LinearLayout mOrderLinearLayout;
    private ImageView mParkImage;
    private TextView mParkDistance;
    private TextView mParkSelling;
    private TextView mParkPhone;
    private TextView mParkSite;

    private TextView mOrderNumber;
    private TextView mOrderState;
    private TextView mMoneyText;
    private TextView mRealityMoneyText;
    private TextView mUserCar;
    private LinearLayout mRealityMoneyLinear;
    private LinearLayout mUserCarLinear;

    private TextView mOrderDate;
    private TextView mStopDate;
    private TextView mLeaveDate;

    private IndentBean mIndentBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_details);

        initView();
        mIndentBean = (IndentBean) getIntent().getSerializableExtra("indentBean");
        initView();
        if (mIndentBean != null) {
            initData(mIndentBean);
        }


    }

    private void initData(IndentBean indentBean) {
        toolbar.setTitle("订单详情");
        setSupportActionBar(toolbar);

        if (indentBean.getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH) {

            Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.bg_finish) + "/"
                    + getResources().getResourceTypeName(R.drawable.bg_finish) + "/"
                    + getResources().getResourceEntryName(R.drawable.bg_finish));
            Glide.with(this).load(uri).into(mImageView);

            mRealityMoneyText.setText("￥"+indentBean.getRealityMoney());
            mUserCar.setText(indentBean.getCar());
            mOrderState.setText("订单完成");
        } else if (indentBean.getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER) {
            Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.bg_order) + "/"
                    + getResources().getResourceTypeName(R.drawable.bg_order) + "/"
                    + getResources().getResourceEntryName(R.drawable.bg_order));
            Glide.with(this).load(uri).into(mImageView);

            mRealityMoneyLinear.setVisibility(View.GONE);
            mUserCarLinear.setVisibility(View.GONE);
            mOrderState.setText("预约完成");
        } else if (indentBean.getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_PROCEED) {
            Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + getResources().getResourcePackageName(R.drawable.bg_proceed) + "/"
                    + getResources().getResourceTypeName(R.drawable.bg_proceed) + "/"
                    + getResources().getResourceEntryName(R.drawable.bg_proceed));
            Glide.with(this).load(uri).into(mImageView);
            mRealityMoneyLinear.setVisibility(View.GONE);
            mUserCar.setText(indentBean.getCar());
            mOrderState.setText("停车中");
        }


        mParkName.setText(indentBean.getParkBean().getParkName());
        mOrderLinearLayout.setOnClickListener(this);
        Glide.with(this).load(indentBean.getParkBean().getParkImage()).into(mParkImage);
        mParkDistance.setText("车位:"+indentBean.getParkPlace()+"号");
        mParkSelling.setText("收费:"+indentBean.getParkBean().getParkSelling()+"元/小时");
        mParkPhone.setText("电话:"+indentBean.getParkBean().getParkPhone());
        mParkSite.setText("地址:"+indentBean.getParkBean().getParkSite());

        mOrderNumber.setText(indentBean.getOrderNumber());
        mMoneyText.setText("￥"+indentBean.getOrderMoney());

        mOrderDate.setText(indentBean.getOrderDate());
        mStopDate.setText(indentBean.getStopDate());
        mLeaveDate.setText(indentBean.getLeaveDate()   );
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mImageView = (ImageView) findViewById(R.id.image);

        mParkName = (TextView) findViewById(R.id.park_name);
        mOrderLinearLayout = (LinearLayout) findViewById(R.id.line1);
        mParkImage = (ImageView) findViewById(R.id.park_image);
        mParkDistance = (TextView) findViewById(R.id.park_distance);
        mParkSelling = (TextView) findViewById(R.id.park_selling);
        mParkPhone = (TextView) findViewById(R.id.park_phone);
        mParkSite = (TextView) findViewById(R.id.park_site);

        mOrderNumber = (TextView) findViewById(R.id.order_number);
        mOrderState = (TextView) findViewById(R.id.order_state);
        mMoneyText = (TextView) findViewById(R.id.money_text);
        mRealityMoneyText = (TextView) findViewById(R.id.reality_money_text);
        mUserCar = (TextView) findViewById(R.id.user_car);
        mRealityMoneyLinear = (LinearLayout) findViewById(R.id.line4);
        mUserCarLinear = (LinearLayout) findViewById(R.id.line5);

        mOrderDate = (TextView) findViewById(R.id.order_date);
        mStopDate = (TextView) findViewById(R.id.stop_date);
        mLeaveDate = (TextView) findViewById(R.id.leave_date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.line1:
                Intent intent = new Intent(App.getContext(), ParkDetailsActivity.class);
                intent.putExtra("parkBean",mIndentBean.getParkBean());
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
View view;

}
