package com.anhtd.instantship.view.activity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.anhtd.instantship.R;
import com.anhtd.instantship.databinding.ActivityLoginBinding;
import com.anhtd.instantship.view.adapter.TutorialPagerAdapter;
import com.anhtd.instantship.view.fragment.OneFragment;
import com.anhtd.instantship.view.fragment.ThreeFragment;
import com.anhtd.instantship.view.fragment.TwoFragment;
import com.anhtd.instantship.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding userBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initDataBingding();
        setupViewPager();
    }

    private void initDataBingding() {
        userBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);
        userBinding.setUserViewModel(loginViewModel);
    }

    private void setupViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        TabLayout tab = (TabLayout) findViewById(R.id.tab_layout);

        List<Fragment> lst = new ArrayList<>();
        lst.add(new OneFragment());
        lst.add(new TwoFragment());
        lst.add(new ThreeFragment());

        TutorialPagerAdapter adapter = new TutorialPagerAdapter(getSupportFragmentManager(), lst);

        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }
}
