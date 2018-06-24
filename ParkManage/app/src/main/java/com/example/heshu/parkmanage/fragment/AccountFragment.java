package com.example.heshu.parkmanage.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.activity.LoginActivity;
import com.example.heshu.parkmanage.activity.MainActivity;
import com.example.heshu.parkmanage.activity.ResortParkActivity;
import com.example.heshu.parkmanage.activity.UserCarActivity;
import com.example.heshu.parkmanage.adapter.ParkOrderRecyclerAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by heshu on 2018/6/11.
 */

public class AccountFragment extends Fragment implements View.OnClickListener {

    private CircleImageView mHeadPortraitl;
    private TextView mUserName;

    private RelativeLayout mOrderLayout;
    private RelativeLayout mCarLayout;
    private RelativeLayout mPlaceLayout;
    private RelativeLayout mFeedbackLayout;
    private RelativeLayout mHelpLayout;
    private RelativeLayout mAsRegardsLayout;

    private Button mQuitLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mOrderLayout = (RelativeLayout) view.findViewById(R.id.line1);
        mCarLayout = (RelativeLayout) view.findViewById(R.id.line2);
        mPlaceLayout = (RelativeLayout) view.findViewById(R.id.line3);
        mFeedbackLayout = (RelativeLayout) view.findViewById(R.id.line4);
        mHelpLayout = (RelativeLayout) view.findViewById(R.id.line5);
        mAsRegardsLayout = (RelativeLayout) view.findViewById(R.id.line6);

        mQuitLogin = (Button) view.findViewById(R.id.quit_login);

        mOrderLayout.setOnClickListener(this);
        mCarLayout.setOnClickListener(this);
        mPlaceLayout.setOnClickListener(this);
        mFeedbackLayout.setOnClickListener(this);
        mHelpLayout.setOnClickListener(this);
        mAsRegardsLayout.setOnClickListener(this);

        mQuitLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.line1:
                ((MainActivity)getActivity()).replaceFragment( new IndentFragment());
                ((MainActivity)getActivity()).toolbar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
                ((MainActivity)getActivity()).toolbar.setVisibility(View.VISIBLE);
                break;
            case R.id.line2: {
                Intent intent = new Intent(getActivity(), UserCarActivity.class);
                getActivity().startActivity(intent);
            }
                break;
            case R.id.line3: {
                Intent intent = new Intent(getActivity(), ResortParkActivity.class);
                getActivity().startActivity(intent);
            }
                break;
            case R.id.line4:
                break;
            case R.id.line5:
                break;
            case R.id.line6:{
                showParkDialog(v);
            }
                break;
            case R.id.quit_login: {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
                break;
            default:
                break;
        }
    }

    private void showParkDialog(View parent ) {


        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View contentView = layoutInflater.inflate(R.layout.fragment_account_regard, null);

        final PopupWindow mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);


        ColorDrawable cd = new ColorDrawable(0x000000);
        mPopupWindow.setBackgroundDrawable(cd);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation((View) parent.getParent(), Gravity.CENTER, 0, 0);


        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        getActivity().getWindow().setAttributes(lp);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);
            }
        });


    }
}
