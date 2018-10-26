package com.example.fly.recyclerviewrefresh.itemView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fly.recyclerviewrefresh.R;
import com.example.fly.recyclerviewrefresh.pojo.BannerVo;
import com.trecyclerview.holder.AbsViewHolder;
import com.trecyclerview.holder.BaseHolder;

/**
 */
public class banner extends AbsViewHolder<BannerVo, banner.ViewHolder> {
    public banner(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.banner;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerVo item) {
        RecyclerView.LayoutParams clp = (RecyclerView.LayoutParams) holder.mBannerView.getLayoutParams();
        if (clp instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) clp).setFullSpan(true);
        }
    }

    static class ViewHolder extends BaseHolder {

        private RelativeLayout mBannerView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBannerView=getViewById(R.id.rl_root_view);
        }

    }

}
