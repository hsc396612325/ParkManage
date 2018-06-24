package com.example.heshu.parkmanage.activity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.adapter.ParkOrderRecyclerAdapter;
import com.example.heshu.parkmanage.adapter.ParkPlaceRecyclerAdapter;
import com.example.heshu.parkmanage.bean.ParkBean;
import com.example.heshu.parkmanage.bean.PlaceBean;
import com.example.heshu.parkmanage.util.App;

import java.util.ArrayList;
import java.util.List;

public class ParkDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ParkDetailsActivity";

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mParkImageView;

    private TextView mParkSiteText; //地址
    private ImageView mNavigationImage; //导航
    private TextView mParkPhoneText;//电话
    private ImageView mCallImage;//打电话
    private TextView mParkSelling;//收费
    private TextView mParkPlaceText;//车位

    private EditText mUserPhonrEdit;//用户电话
    private RelativeLayout mChoiceCarRelativeLayout;//选择车辆
    private TextView mUserCarText;//用户车辆
    private RelativeLayout mChoicePlaceRelativeLayout;//选择车位
    private TextView mUserPlaceText;//用户车辆

    private RelativeLayout mChoiceOrderRelativeLayout;//选择时长
    private TextView mUserOrder;//用户预约时常

    private EditText mUserRemark;//备注

    private FloatingActionButton mFloatingActionButton;

    private ParkBean mParkBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_details);

        mParkBean = (ParkBean) getIntent().getSerializableExtra("parkBean");
        initView();
        if (mParkBean != null) {
            initData(mParkBean);
        }


    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mCollapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        mParkImageView = findViewById(R.id.park_image);

        mParkSiteText = findViewById(R.id.park_site);
        mNavigationImage = findViewById(R.id.park_navigation);
        mParkPhoneText = findViewById(R.id.park_phone);
        mCallImage = findViewById(R.id.park_call);
        mParkSelling = findViewById(R.id.park_selling);
        mParkPlaceText = findViewById(R.id.park_place);
        mNavigationImage.setOnClickListener(this);
        mCallImage.setOnClickListener(this);

        mUserPhonrEdit = findViewById(R.id.user_phone);
        mChoiceCarRelativeLayout = findViewById(R.id.line_car);
        mUserCarText = findViewById(R.id.user_car);
        mChoicePlaceRelativeLayout = findViewById(R.id.line_place);
        mUserPlaceText = findViewById(R.id.user_place);
        mChoiceCarRelativeLayout.setOnClickListener(this);
        mChoicePlaceRelativeLayout.setOnClickListener(this);

        mChoiceOrderRelativeLayout = findViewById(R.id.line_order);
        mUserOrder = findViewById(R.id.user_order);
        mUserRemark = findViewById(R.id.user_remark);
        mChoiceOrderRelativeLayout.setOnClickListener(this);

        mFloatingActionButton = findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(this);
        mUserPhonrEdit.setCursorVisible(false);
        mUserPhonrEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserPhonrEdit.setCursorVisible(true);
            }
        });

        mUserRemark.setCursorVisible(false);
        mUserRemark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRemark.setCursorVisible(true);
            }
        });
    }

    private void initData(ParkBean parkBean) {
        Log.d(TAG, "initData: "+parkBean.getParkName());
        mCollapsingToolbarLayout.setTitle(parkBean.getParkName());
        Glide.with(App.getContext()).load(parkBean.getParkImage()).into(mParkImageView);

        mParkSiteText.setText(parkBean.getParkSite());
        mParkPhoneText.setText(parkBean.getParkPhone());
        mParkSelling.setText(parkBean.getParkSelling() + "元/小时");
        mParkPlaceText.setText(parkBean.getParkUsableNum() + "/" + parkBean.getParkNum());
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.park_navigation: {
                String uri = "amapuri://route/plan/?dlat=" + mParkBean.getDlat() + "&dlon=" + mParkBean.getDlon() + "&dname=" + mParkBean.getParkName() + "&dev=1&t=0";
                Intent intent = new Intent("android.intent.action.VIEW", android.net.Uri.parse(uri));
                intent.setPackage("com.autonavi.minimap");
                this.startActivity(intent);
            }
            break;
            case R.id.park_call: {
                if (ContextCompat.checkSelfPermission(ParkDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ParkDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
            }
            break;
            case R.id.line_car: {
                final List<String> mStrings = new ArrayList();
                mStrings.add("选择车辆");
                mStrings.add("车辆1");
                mStrings.add("车辆2");
                mStrings.add("车辆3");
                mStrings.add("车辆4");
                showParkDialog(v, mStrings);
            }
            break;

            case R.id.line_place: {
                final List<PlaceBean> placeBeans = new ArrayList<>();

                for (int i = 1; i < 31; i++) {
                    int j = (int) (Math.random() * 100 % 3);
                    Log.d(TAG, "onClick: " + j);
                    PlaceBean placeBean = new PlaceBean();
                    placeBean.setId(i);
                    if (j == 0) {
                        placeBean.setState(PlaceBean.placeState.CHOOSE);
                    } else if (j == 1) {
                        placeBean.setState(PlaceBean.placeState.NO);
                    } else if (j == 2) {
                        placeBean.setState(PlaceBean.placeState.ORDER);
                    }
                    placeBeans.add(placeBean);
                }
                showPlaceDialog(v, placeBeans);
            }

            break;

            case R.id.line_order: {
                final List<String> mStrings = new ArrayList();
                mStrings.add("选择预约时长");
                mStrings.add("10分钟");
                mStrings.add("20分钟");
                mStrings.add("30分钟");
                mStrings.add("40分钟");
                mStrings.add("50分钟");
                mStrings.add("一小时");
                showParkDialog(v, mStrings);
            }
            break;

            case  R.id.fab:
                finish();
                Toast.makeText(this, "预约成功", Toast.LENGTH_SHORT).show();
            default:
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "未赋予权限，无法拨打电话", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
        }
    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data = Uri.parse("tel:" + mParkBean.getParkPhone());
            intent.setData(data);
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void showParkDialog(View parent, final List<String> mStrings) {


        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View contentView = layoutInflater.inflate(R.layout.activity_park_details_recycler, null);

        final PopupWindow mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        RecyclerView recyclerView = contentView.findViewById(R.id.order_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ParkOrderRecyclerAdapter adapter = new ParkOrderRecyclerAdapter(mStrings);
        adapter.setItemClickListener(new ParkOrderRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mPopupWindow.dismiss();
                if (position != 0) {
                    if (mStrings.get(0).equals("选择预约时长")) {
                        mUserOrder.setText(mStrings.get(position));
                    } else if (mStrings.get(0).equals("选择车辆")) {
                        mUserCarText.setText(mStrings.get(position));
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter);


        ColorDrawable cd = new ColorDrawable(0x000000);
        mPopupWindow.setBackgroundDrawable(cd);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation((View) parent.getParent(), Gravity.CENTER, 0, 0);


        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });


    }

    private void showPlaceDialog(View parent, final List<PlaceBean> placeBeans) {


        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View contentView = layoutInflater.inflate(R.layout.activity_park_details_place, null);

        final PopupWindow mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        RecyclerView recyclerView = contentView.findViewById(R.id.order_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        ParkPlaceRecyclerAdapter adapter = new ParkPlaceRecyclerAdapter(placeBeans, this);
        adapter.setItemClickListener(new ParkPlaceRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Log.d(TAG, "onItemClick: " + position);
                if (placeBeans.get(position).getState() == PlaceBean.placeState.CHOOSE) {
                    mPopupWindow.dismiss();
                    mUserPlaceText.setText(placeBeans.get(position).getId() + "号");
                } else if (placeBeans.get(position).getState() == PlaceBean.placeState.NO) {
                    Toast.makeText(ParkDetailsActivity.this, "该车位被占用", Toast.LENGTH_SHORT).show();
                } else if (placeBeans.get(position).getState() == PlaceBean.placeState.ORDER) {
                    Toast.makeText(ParkDetailsActivity.this, "该车位被预约", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(adapter);


        ColorDrawable cd = new ColorDrawable(0x000000);
        mPopupWindow.setBackgroundDrawable(cd);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation((View) parent.getParent(), Gravity.CENTER, 0, 0);


        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });


    }
}
