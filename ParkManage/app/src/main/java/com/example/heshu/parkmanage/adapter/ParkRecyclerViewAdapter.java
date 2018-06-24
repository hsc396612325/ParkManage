package com.example.heshu.parkmanage.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.activity.ParkDetailsActivity;
import com.example.heshu.parkmanage.bean.ParkBean;
import com.example.heshu.parkmanage.util.App;

import java.util.List;

/**
 * Created by heshu on 2018/6/11.
 */

public class ParkRecyclerViewAdapter extends RecyclerView.Adapter<ParkRecyclerViewAdapter.ViewHolder> {

    private List<ParkBean> mParkBeanList;
    private Context mContext;
    private static final String TAG = "ParkRecyclerViewAdapter";

    public ParkRecyclerViewAdapter(List<ParkBean> parkBeanList, Context context) {
        mParkBeanList = parkBeanList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pack_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ParkBean parkBean = mParkBeanList.get(position);
        holder.parkName.setText(parkBean.getParkName());
        holder.parkSite.setText("地址:" + parkBean.getParkSite());
        holder.parkSelling.setText("费用:" + parkBean.getParkSelling() + "元/小时");
        holder.parkDistance.setText("距离:约" + 1600 + "m");
        holder.parkUsable.setText("可用车位:" + parkBean.getParkUsableNum());

        Glide.with(App.getContext()).load(parkBean.getParkImage()).into(holder.parkImage);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.getContext(), ParkDetailsActivity.class);
                intent.putExtra("parkBean", parkBean);
                ((Activity) mContext).startActivity(intent);
            }
        });

        Log.d(TAG, "onBindViewHolder: " + parkBean.getParkImage());
    }

    @Override
    public int getItemCount() {
        return mParkBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView parkName;
        TextView parkSite;
        TextView parkSelling;
        TextView parkDistance;
        TextView parkUsable;
        ImageView parkImage;
        View mView;

        public ViewHolder(View view) {
            super(view);
            parkName = (TextView) view.findViewById(R.id.park_name);
            parkSite = (TextView) view.findViewById(R.id.park_site);
            parkSelling = (TextView) view.findViewById(R.id.park_selling);
            parkDistance = (TextView) view.findViewById(R.id.park_distance);
            parkUsable = (TextView) view.findViewById(R.id.park_usable);
            parkImage = (ImageView) view.findViewById(R.id.park_image);
            mView = view;
        }
    }
}
