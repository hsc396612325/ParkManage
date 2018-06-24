package com.example.heshu.parkmanage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.bean.CarBean;

import java.util.List;

/**
 * Created by heshu on 2018/6/21.
 */

public class UserCarAdapter extends RecyclerView.Adapter<UserCarAdapter.ViewHolder> {
    List<CarBean> mCarBeanList;

    public UserCarAdapter(List<CarBean> carBeans) {
        mCarBeanList = carBeans;
    }

    @Override
    public UserCarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_car_item, parent, false);
        UserCarAdapter.ViewHolder holder = new UserCarAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserCarAdapter.ViewHolder holder, int position) {
        holder.carTrademark.setText(mCarBeanList.get(position).getCarTrademark());
        holder.carColor.setText(mCarBeanList.get(position).getCarColor());
        holder.carPlateNumber.setText(mCarBeanList.get(position).getCarPlateNumber());
        holder.carName.setText(mCarBeanList.get(position).getCarName());
    }

    @Override
    public int getItemCount() {
        return mCarBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView carPlateNumber;
        TextView carColor;
        TextView carTrademark;
        TextView carName;
        TextView carCompile;
        TextView carRemove;

        public ViewHolder(View view) {
            super(view);

            carPlateNumber = view.findViewById(R.id.user_car_plate_number);
            carColor = view.findViewById(R.id.user_car_color);
            carTrademark = view.findViewById(R.id.user_car_trademark);
            carName = view.findViewById(R.id.user_car_name);
            carCompile = view.findViewById(R.id.user_car_compile);
            carRemove = view.findViewById(R.id.user_car_remove);
        }
    }
}
