package com.robot.myapplication;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView mImgHome;
    private ImageView mImgProduct;
    private ImageView mImgMore;

    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgHome = (ImageView) findViewById(R.id.imgHome);
        mImgProduct = (ImageView) findViewById(R.id.imgProduct);
        mImgMore = (ImageView) findViewById(R.id.imgMore);

        mImgHome.setOnClickListener(this);
        mImgProduct.setOnClickListener(this);
        mImgMore.setOnClickListener(this);

        imageViewList.add(mImgHome);
        imageViewList.add(mImgProduct);
        imageViewList.add(mImgMore);

        mImgHome.performClick();
    }

    @Override
    public void onClick(View v) {
        changeBottomBtnBackgroud(v);
    }

    private void changeBottomBtnBackgroud(View v) {
        for (int i = 0; i < imageViewList.size(); i++) {
            ImageView imageView = imageViewList.get(i);
            if (v == imageView) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,(int)getResources().getDimension(R.dimen.bottom_btn_press_height), 1.0f);
                imageView.setLayoutParams(lp);
                // 注意需要设置这个属性，对应的xml中的属性为layout_gravity="bottom"
                lp.gravity = Gravity.BOTTOM;
                setBottomBtnBackgroud(imageView, true);
            } else {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
                imageView.setLayoutParams(lp);
                setBottomBtnBackgroud(imageView, false);
            }
        }
    }

    private void setBottomBtnBackgroud(ImageView imageView, boolean isPress) {
        if (isPress) {
            if (imageView.getId() == R.id.imgHome) {
                imageView.setImageResource(R.mipmap.home_press);
            } else if (imageView.getId() == R.id.imgProduct) {
                imageView.setImageResource(R.mipmap.product_press);
            } else {
                imageView.setImageResource(R.mipmap.more_press);
            }
        } else {
            if (imageView.getId() == R.id.imgHome) {
                imageView.setImageResource(R.mipmap.home);
            } else if (imageView.getId() == R.id.imgProduct) {
                imageView.setImageResource(R.mipmap.product);
            } else {
                imageView.setImageResource(R.mipmap.more);
            }
        }
    }
}
