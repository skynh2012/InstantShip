package com.anhtd.instantship.view.activity;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.anhtd.instantship.R;
import com.anhtd.instantship.databinding.ActivityTutorialBinding;
import com.anhtd.instantship.utils.AppUtils;
import com.anhtd.instantship.utils.ScreenUtils;
import com.anhtd.instantship.view.adapter.BottomSheetFragment;
import com.anhtd.instantship.view.adapter.ViewPagerAdapter;
import com.anhtd.instantship.view.fragment.OneFragment;
import com.anhtd.instantship.view.fragment.ThreeFragment;
import com.anhtd.instantship.view.fragment.TwoFragment;
import com.anhtd.instantship.viewModel.LoginViewModel;

public class TutorialActivity extends AppCompatActivity {

    private ActivityTutorialBinding binding;
    private LoginViewModel viewModel;
    private LoginHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initDataBingding();

    }


    private void initDataBingding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial);
        viewModel = new LoginViewModel(this);
        binding.setViewModel(viewModel);
        binding.setAdapter(this);
        binding.setManager(getSupportFragmentManager());
        handler = new LoginHandler();
        binding.setHandler(handler);
    }


    @BindingAdapter("bind:adapter")
    public static void bindViewPagerAdapter(ViewPager viewPager, TutorialActivity activity) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(activity.getSupportFragmentManager());
        adapter.addFragment(OneFragment.newInstance(), "");
        adapter.addFragment(TwoFragment.newInstance(), "");
        adapter.addFragment(ThreeFragment.newInstance(), "");
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("bind:pager")
    public static void bindPagerTabs(TabLayout tab, ViewPager viewPager) {
        tab.setupWithViewPager(viewPager, true);
    }


    public class LoginHandler {
        public void onLoginPressed(View view) {
            AppUtils.startActivityLTR(TutorialActivity.this, LoginActivity.class);
        }

        public void onRegisterPressed(View view) {
            AppUtils.startActivityLTR(TutorialActivity.this, RegisterActivity.class);
        }
    }
}
