package com.example.fly.imageloagutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.fly.imageloader.ImageLoaderManager;
import com.fly.imageloader.tranform.BlurBitmapTranformation;
import com.fly.imageloader.tranform.GlideCircleTransformation;
import com.fly.imageloader.tranform.RoundBitmapTranformation;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView_1;
    private ImageView mImageView_2;
    private ImageView mImageView_3;
    private ImageView mImageView_4;
    private ImageView mImageView_5;
    private ImageView mImageView_6;
    private ImageView mImageView_7;
    private ImageView mImageView_8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        String url="http://img5.imgtn.bdimg.com/it/u=3532743473,184108530&fm=200&gp=0.jpg";
        // 圆形图片
        ImageLoaderManager.getInstance().displayCircleImage(this, url, mImageView_1, R.mipmap.ic_launcher_round);
        // 圆角图片
        ImageLoaderManager.getInstance().displayRoundImage(this, url, mImageView_2, R.mipmap.ic_launcher_round, 40);

        ImageLoaderManager.getInstance().displayImageInResource(this, R.mipmap.ic_launcher, mImageView_4);
        //本地图片，模糊处理
        ImageLoaderManager.getInstance().displayImageInResource(this, R.mipmap.ic_launcher, mImageView_5, new BlurBitmapTranformation( 200));
        //本地图片，裁圆角处理
        ImageLoaderManager.getInstance().displayImageInResource(this, R.mipmap.ic_launcher, mImageView_6, new GlideCircleTransformation());
        //四周圆角处理
        ImageLoaderManager.getInstance().displayImageInResource(this, R.mipmap.ic_launcher, mImageView_7, new RoundBitmapTranformation( 40));
    }

    private void findView() {
        mImageView_1 = findViewById(R.id.image_view_1);
        mImageView_2 = findViewById(R.id.image_view_2);
        mImageView_3 = findViewById(R.id.image_view_3);
        mImageView_4 = findViewById(R.id.image_view_4);
        mImageView_5 = findViewById(R.id.image_view_5);
        mImageView_6 = findViewById(R.id.image_view_6);
        mImageView_7 = findViewById(R.id.image_view_7);
        mImageView_8 = findViewById(R.id.image_view_8);
    }
}