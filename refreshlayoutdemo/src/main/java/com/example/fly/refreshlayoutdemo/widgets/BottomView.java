package com.example.fly.refreshlayoutdemo.widgets;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fly.refreshlayoutdemo.R;
import com.example.refreshlayout.IBottomWrapper;


public class BottomView extends LinearLayout implements IBottomWrapper {

    public BottomView(Context context) {
        this(context, null);
    }

    public BottomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setBackgroundColor(Color.parseColor("#F5F8F9"));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_refresh_bottom,this,false);
        addView(view);
    }

    @Override
    public View getBottomView() {
        return this;
    }

    @Override
    public void showBottom() {

    }
}
