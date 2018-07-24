package com.anhtd.instantship.view.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.anhtd.instantship.R;
import com.anhtd.instantship.utils.AppUtils;

public class PlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plash);

        checkFirstApp();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setLanguage();
                AppUtils.startActivityLTR(PlashActivity.this, TutorialActivity.class);
                finish();
            }
        }, 2000);
    }

    private void checkFirstApp() {

    }

    private void setLanguage() {

    }
}
