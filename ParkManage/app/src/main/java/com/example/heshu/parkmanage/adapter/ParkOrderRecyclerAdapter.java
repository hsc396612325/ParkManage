package com.example.heshu.parkmanage.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heshu.parkmanage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshu on 2018/6/13.
 */

public class ParkOrderRecyclerAdapter extends RecyclerView.Adapter<ParkOrderRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    List<String> mStrings;
    private OnItemClickListener mItemClickListener;

    private static final String TAG = "ParkOrderRecyclerAdapte";

    public ParkOrderRecyclerAdapter(List<String> list) {
        mStrings = list;
        Log.d(TAG, "ParkOrderRecyclerAdapter: ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_park_details_order_item, parent, false);
        ParkOrderRecyclerAdapter.ViewHolder holder = new ParkOrderRecyclerAdapter.ViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mStrings.get(position));
        holder.mView.setTag(position);
        if (position == 0) {
            holder.textView.setTextSize(16);
        }

    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener!=null){
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View mView;
        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text);
            mView = view;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
