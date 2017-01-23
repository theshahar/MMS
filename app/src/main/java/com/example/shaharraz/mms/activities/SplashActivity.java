package com.example.shaharraz.mms.activities;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.example.shaharraz.mms.R;
import com.example.shaharraz.mms.utilities.MyConnectivityChecker;

public class SplashActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private static final long TIME = 1000;
    private boolean isConnected;
    private boolean isActive;
    private TextView txtSplash;
    private Handler mHandler = new Handler();
    private MainActivityRunnable mMainActivityRunnable = new MainActivityRunnable(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        txtSplash = (TextView) findViewById(R.id.txtSplash);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(txtSplash, "alpha", 0f, 1f);
        fadeIn.setDuration(4000);
        final AnimatorSet mAnimationSet = new AnimatorSet();
        mAnimationSet.play(fadeIn);
        mAnimationSet.start();
        mAnimationSet.addListener(this);


        //check if there is connection to the internet
        if (MyConnectivityChecker.isConnected(this)) {
            isConnected = true;
        } else {
            isConnected = false;
        }


    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

        if (isConnected) {
            if (isActive) {
                mHandler.postDelayed(mMainActivityRunnable, TIME);
            } else {
                mMainActivityRunnable.destroy();
                finish();
            }


        } else {
            //there is no connection to the internet
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.internet_error_title);
            builder.setMessage(R.string.internet_error_msg)
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();


        }


    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }


    private void goToMainActivity() {

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        isActive = true;

    }


    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mMainActivityRunnable);
        mMainActivityRunnable.destroy();
    }


    private static class MainActivityRunnable implements Runnable {
        private SplashActivity mSplashActivity;

        public MainActivityRunnable(SplashActivity splashActivity) {
            mSplashActivity = splashActivity;
        }

        @Override
        public void run() {
            mSplashActivity.goToMainActivity();
            destroy();
        }

        public void destroy() {
            mSplashActivity = null;
        }


    }


}



