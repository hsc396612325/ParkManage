package com.example.heshu.parkmanage.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.bean.IndentBean;

import java.util.List;

/**
 * Created by heshu on 2018/6/11.
 */

public class IndentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private static final String TAG = "ParkRecyclerViewAdapter";
    private OnItemClickListener mItemClickListener;
    private List<IndentBean> mIndentBeanList;

    public IndentRecyclerViewAdapter(List<IndentBean> list) {
        mIndentBeanList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == IndentBean.ITEM_TYPE.ITEM_TYPE_ABOLISH.ordinal()) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_indent_abolish_item, parent, false);
            AbolishViewHolder holder = new AbolishViewHolder(view);
            return holder;
        } else if (viewType == IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER.ordinal()) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_indent_order_item, parent, false);
            OrderViewHolder holder = new OrderViewHolder(view);
            holder.mView.setOnClickListener(this);
            return holder;
        } else if (viewType == IndentBean.ITEM_TYPE.ITEM_TYPE_PROCEED.ordinal()) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_indent_proceed_item, parent, false);
            ProceedViewHolder holder = new ProceedViewHolder(view);
            holder.mView.setOnClickListener(this);
            return holder;
        } else if (viewType == IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH.ordinal()) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_indent_finish_item, parent, false);
            FinishViewHolder holder = new FinishViewHolder(view);
            holder.mView.setOnClickListener(this);
            return holder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_ABOLISH) {
            AbolishViewHolder abolishViewHolder = (AbolishViewHolder) holder;

            abolishViewHolder.mOrderNumber.setText(mIndentBeanList.get(position).getOrderNumber());
            abolishViewHolder.mParkPlace.setText("# "+mIndentBeanList.get(position).getParkPlace());
            abolishViewHolder.mParkName.setText(mIndentBeanList.get(position).getParkBean().getParkName());
            abolishViewHolder.mMoneyText.setText("￥"+mIndentBeanList.get(position).getOrderMoney());

        } else if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER) {
            OrderViewHolder orderViewHolder = (OrderViewHolder) holder;

            orderViewHolder.mView.setTag(position);
            orderViewHolder.mOrderNumber.setText(mIndentBeanList.get(position).getOrderNumber());
            orderViewHolder.mParkPlace.setText("# "+mIndentBeanList.get(position).getParkPlace());
            orderViewHolder.mParkName.setText(mIndentBeanList.get(position).getParkBean().getParkName());
            orderViewHolder.mMoneyText.setText("￥"+mIndentBeanList.get(position).getOrderMoney());

        } else if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH) {

            FinishViewHolder finishViewHolder = ( FinishViewHolder) holder;

            finishViewHolder.mView.setTag(position);
            finishViewHolder.mOrderNumber.setText(mIndentBeanList.get(position).getOrderNumber());
            finishViewHolder.mParkPlace.setText("# "+mIndentBeanList.get(position).getParkPlace());
            finishViewHolder.mParkName.setText(mIndentBeanList.get(position).getParkBean().getParkName());
            finishViewHolder.mMoneyText.setText("￥"+mIndentBeanList.get(position).getOrderMoney());
            finishViewHolder.mRealityMoney.setText("￥"+mIndentBeanList.get(position).getRealityMoney());
        } else {
            ((ProceedViewHolder) holder).mView.setTag(position);

            ProceedViewHolder proceedViewHolder = (ProceedViewHolder) holder;

            proceedViewHolder.mView.setTag(position);
            proceedViewHolder.mOrderNumber.setText(mIndentBeanList.get(position).getOrderNumber());
            proceedViewHolder.mParkPlace.setText("# "+mIndentBeanList.get(position).getParkPlace());
            Log.d(TAG, "onBindViewHolder: "+mIndentBeanList.get(position).getParkBean());
            proceedViewHolder.mParkName.setText(mIndentBeanList.get(position).getParkBean().getParkName());
            proceedViewHolder.mMoneyText.setText("￥"+mIndentBeanList.get(position).getOrderMoney());
            proceedViewHolder.mRealityMoney.setText("￥"+mIndentBeanList.get(position).getRealityMoney());
        }

    }

    @Override
    public int getItemCount() {
        return mIndentBeanList.size();
    }

    public int getItemViewType(int position) {
        if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_ABOLISH) {
            return IndentBean.ITEM_TYPE.ITEM_TYPE_ABOLISH.ordinal();
        } else if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER) {
            return IndentBean.ITEM_TYPE.ITEM_TYPE_ORDER.ordinal();
        } else if (mIndentBeanList.get(position).getITEM_type() == IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH) {
            return IndentBean.ITEM_TYPE.ITEM_TYPE_FINISH.ordinal();
        } else {
            return IndentBean.ITEM_TYPE.ITEM_TYPE_PROCEED.ordinal();
        }
    }


    static class AbolishViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mOrderNumber;
        TextView mParkPlace;
        TextView mParkName;
        TextView mMoneyText;

        public AbolishViewHolder(View view) {
            super(view);
            mView = view;
            mOrderNumber = (TextView) view.findViewById(R.id.order_number);
            mParkPlace = (TextView) view.findViewById(R.id.park_place);
            mParkName = (TextView) view.findViewById(R.id.park_name);
            mMoneyText = (TextView) view.findViewById(R.id.money_text);
        }
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mOrderNumber;
        TextView mParkPlace;
        TextView mParkName;
        TextView mMoneyText;

        Button mCancelButton;
        Button mEnsureButton;
        public OrderViewHolder(View view) {
            super(view);
            mView = view;
            mOrderNumber = (TextView) view.findViewById(R.id.order_number);
            mParkPlace = (TextView) view.findViewById(R.id.park_place);
            mParkName = (TextView) view.findViewById(R.id.park_name);
            mMoneyText = (TextView) view.findViewById(R.id.money_text);
            mCancelButton = (Button)view.findViewById(R.id.cancel_button);
            mEnsureButton = (Button)view.findViewById(R.id.ensure_button);
        }
    }

    static class ProceedViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView mOrderNumber;
        TextView mParkPlace;
        TextView mParkName;
        TextView mMoneyText;
        TextView mRealityMoney;

        Button mCancelButton;
        Button mEnsureButton;
        public  ProceedViewHolder(View view) {
            super(view);
            mView = view;
            mOrderNumber = (TextView) view.findViewById(R.id.order_number);
            mParkPlace = (TextView) view.findViewById(R.id.park_place);
            mParkName = (TextView) view.findViewById(R.id.park_name);
            mMoneyText = (TextView) view.findViewById(R.id.money_text);
            mRealityMoney = (TextView)view.findViewById(R.id.reality_money_text);

            mCancelButton = (Button)view.findViewById(R.id.cancel_button);
            mEnsureButton = (Button)view.findViewById(R.id.ensure_button);
        }
    }

    static class FinishViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView mOrderNumber;
        TextView mParkPlace;
        TextView mParkName;
        TextView mMoneyText;
        TextView mRealityMoney;

        public  FinishViewHolder(View view) {
            super(view);
            mView = view;
            mOrderNumber = (TextView) view.findViewById(R.id.order_number);
            mParkPlace = (TextView) view.findViewById(R.id.park_place);
            mParkName = (TextView) view.findViewById(R.id.park_name);
            mMoneyText = (TextView) view.findViewById(R.id.money_text);
            mRealityMoney = (TextView)view.findViewById(R.id.reality_money_text);

        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: V");
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }
}
