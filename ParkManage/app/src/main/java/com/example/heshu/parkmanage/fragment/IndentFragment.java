package com.example.heshu.parkmanage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.activity.IndentDetailsActivity;
import com.example.heshu.parkmanage.adapter.IndentRecyclerViewAdapter;
import com.example.heshu.parkmanage.bean.IndentBean;
import com.example.heshu.parkmanage.bean.ParkBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshu on 2018/6/11.
 */

public class IndentFragment extends Fragment {

    private static final String TAG = "IndentFragment";
    List<IndentBean> mIndentBeanList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indent,container,false);

        initData();
        initView(view);
        return  view;
    }

    private void initData() {
        ParkBean parkBean = new ParkBean();
        parkBean.setParkName("海琳建材城停车场");
        parkBean.setParkSite("西安是长安区韦曲北街南50m");
        parkBean.setParkPhone("18700968831");
        parkBean.setParkSelling(12);
        parkBean.setParkUsableNum(10);
        parkBean.setParkNum(50);
        parkBean.setDlat(34.1649100000);
        parkBean.setDlon(108.9057700000);
        parkBean.setParkImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528732334954&di=d046996870bb9056f86463819ecf2e53&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Dfee6470b79f08202399f997c23929198%2F5bafa40f4bfbfbedf8c9955772f0f736afc31f01.jpg");

        ParkBean parkBean2 = new ParkBean();
        parkBean2.setParkName("爱蓝堡停车场");
        parkBean2.setParkSite("府东二路36号");
        parkBean2.setParkPhone("19700968831");
        parkBean2.setParkSelling(11);
        parkBean2.setParkUsableNum(14);
        parkBean2.setParkNum(40);
        parkBean2.setDlat(34.1592510000);
        parkBean2.setDlon(108.9137050000);
        parkBean2.setParkImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3207536318,1097956328&fm=200&gp=0.jpg");

        ParkBean parkBean3 = new ParkBean();
        parkBean3.setParkName("茅坡新城停车场");
        parkBean3.setParkSite("樱花二路与毛坡村交叉口东150m");
        parkBean3.setParkPhone("19700968842");
        parkBean3.setParkSelling(12);
        parkBean3.setParkUsableNum(10);
        parkBean3.setParkNum(30);
        parkBean3.setDlat(34.1653710000);
        parkBean3.setDlon(108.8941830000);
        parkBean3.setParkImage("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2694450368,1214415325&fm=200&gp=0.jpg");

        ParkBean parkBean4= new ParkBean();
        parkBean4.setParkName("万科生活广场停车场");
        parkBean4.setParkSite("西电子路238号");
        parkBean4.setParkPhone("19700968731");
        parkBean4.setParkSelling(20);
        parkBean4.setParkUsableNum(300);
        parkBean4.setParkNum(400);
        parkBean4.setDlat(34.1610382300);
        parkBean4.setDlon(108.8860784200);
        parkBean4.setParkImage("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=995973629,334437766&fm=200&gp=0.jpg");

        mIndentBeanList = new ArrayList<>();
        IndentBean indentBean = new IndentBean();
        indentBean.setITEM_type(IndentBean.ITEM_TYPE.ITEM_TYPE_PROCEED);
        indentBean.setCar("车辆1");
        indentBean.setOrderNumber("120180607758469598");
        indentBean.setOrderMoney(24);
        indentBean.setRealityMoney(24);
        indentBean.setParkBean(parkBean);
        indentBean.setParkPlace(5);
        indentBean.setOrderDate("2018.01.23 11:20");
        indentBean.setStopDate("2018.01.23 14:20");
        indentBean.setLeaveDate("2018.01.24 12:00");
        mIndentBeanList.add(indentBean);

        IndentBean indentBean2 = new IndentBean();
        indentBean2.setITEM_type(IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER);
        indentBean2.setCar("车辆2");
        indentBean2.setOrderNumber("120180607758469511");
        indentBean2.setOrderMoney(30);
        indentBean2.setRealityMoney(30);
        indentBean2.setParkBean(parkBean2);
        indentBean2.setParkPlace(6);
        indentBean2.setOrderDate("2018.01.24 11:20");
        indentBean2.setStopDate("2018.01.24 14:20");
        indentBean2.setLeaveDate("2018.01.25 12:00");
        mIndentBeanList.add(indentBean2);

        IndentBean indentBean3 = new IndentBean();
        indentBean3.setITEM_type(IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH);
        indentBean3.setCar("车辆3");
        indentBean3.setOrderNumber("1201806077584695111");
        indentBean3.setOrderMoney(44);
        indentBean3.setRealityMoney(44);
        indentBean3.setParkBean(parkBean3);
        indentBean3.setParkPlace(7);
        indentBean3.setOrderDate("2018.01.25 11:20");
        indentBean3.setStopDate("2018.01.25 14:20");
        indentBean3.setLeaveDate("2018.01.26 12:00");
        mIndentBeanList.add(indentBean3);

        IndentBean indentBean4 = new IndentBean();
        indentBean4.setITEM_type(IndentBean.ITEM_TYPE.ITEM_TYPE_ABOLISH);
        indentBean4.setCar("车辆1");
        indentBean4.setOrderNumber("120180607758469008");
        indentBean4.setOrderMoney(24);
        indentBean4.setRealityMoney(24);
        indentBean4.setParkBean(parkBean4);
        indentBean4.setParkPlace(8);
        indentBean4.setOrderDate("2018.01.26 11:20");
        indentBean4.setStopDate("2018.01.26 14:20");
        indentBean4.setLeaveDate("2018.01.27 12:00");
        mIndentBeanList.add(indentBean4);
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.park_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        IndentRecyclerViewAdapter adapter = new IndentRecyclerViewAdapter(mIndentBeanList);
        adapter.setItemClickListener(new IndentRecyclerViewAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "onItemClick: sss");
                Intent intent = new Intent(getActivity(), IndentDetailsActivity.class);
                intent.putExtra("indentBean", mIndentBeanList.get(position));
                getActivity().startActivity(intent);

            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

}
