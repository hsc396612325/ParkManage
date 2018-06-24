package com.example.heshu.parkmanage.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.bean.PlaceBean;

import java.util.List;

/**
 * Created by heshu on 2018/6/13.
 */

public class ParkPlaceRecyclerAdapter extends RecyclerView.Adapter<ParkPlaceRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    List<PlaceBean> mPlaceBeans;
    Context mContext;
    private OnItemClickListener mItemClickListener;

    private static final String TAG = "ParkPlaceRecyclerAdapter";

    public ParkPlaceRecyclerAdapter(List<PlaceBean> list, Context context) {
        mPlaceBeans = list;
        mContext = context;
        Log.d(TAG, "ParkOrderRecyclerAdapter: ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_park_details_place_item, parent, false);
        ParkPlaceRecyclerAdapter.ViewHolder holder = new ParkPlaceRecyclerAdapter.ViewHolder(view);
        holder.button.setOnClickListener(this);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + mPlaceBeans.get(position).getId());

        holder.button.setText("" + mPlaceBeans.get(position).getId());
        holder.button.setTag(position);

        if (mPlaceBeans.get(position).getState() == PlaceBean.placeState.CHOOSE) {
            holder.button.setBackground(mContext.getResources().getDrawable(R.drawable.btn_selector_choose));
        } else if (mPlaceBeans.get(position).getState() == PlaceBean.placeState.NO) {
            holder.button.setBackground(mContext.getResources().getDrawable(R.drawable.btn_selector_no));
        } else if (mPlaceBeans.get(position).getState() == PlaceBean.placeState.ORDER) {
            holder.button.setBackground(mContext.getResources().getDrawable(R.drawable.btn_selector_order));
        }


    }

    @Override
    public int getItemCount() {
        return mPlaceBeans.size();
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: V");
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        View mView;

        public ViewHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.button);
            mView = view;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
