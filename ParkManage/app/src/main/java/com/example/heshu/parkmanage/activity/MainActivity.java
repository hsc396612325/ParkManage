package com.example.heshu.parkmanage.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.example.heshu.parkmanage.R;
import com.example.heshu.parkmanage.fragment.AccountFragment;
import com.example.heshu.parkmanage.fragment.IndentFragment;
import com.example.heshu.parkmanage.fragment.ParkFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_park:
                    replaceFragment( new ParkFragment());
                    toolbar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
                    toolbar.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_indent:
                    replaceFragment( new IndentFragment());
                    toolbar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
                    toolbar.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_account:
                    replaceFragment( new AccountFragment());
                    toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator());
                    toolbar.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    private void initView(){

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment( new ParkFragment());
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.search_edit_frame,fragment).commit();
    }

}
