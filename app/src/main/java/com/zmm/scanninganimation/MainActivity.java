package com.zmm.scanninganimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.iv_device_cali_shoes)
    ImageView mIvDeviceCaliShoes;
    @InjectView(R.id.iv_device_cali_scanning)
    ImageView mIvDeviceCaliScanning;

    private Animation mScanningAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        int left = mIvDeviceCaliShoes.getLeft();
        int right = mIvDeviceCaliShoes.getRight();
        int top = mIvDeviceCaliShoes.getTop();
        int bottom = mIvDeviceCaliShoes.getBottom();

        int height = mIvDeviceCaliScanning.getHeight()/2;

        mScanningAnimation = new TranslateAnimation(left, left, top-height, bottom-height);
        mScanningAnimation.setDuration(500); // 动画持续时间
        mScanningAnimation.setRepeatCount(Animation.INFINITE); // 无限循环

        // 播放动画
        mIvDeviceCaliScanning.setAnimation(mScanningAnimation);
        mScanningAnimation.startNow();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScanningAnimation.cancel();
    }
}
