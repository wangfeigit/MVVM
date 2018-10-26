package com.example.fly.recyclerviewrefresh.itemView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fly.recyclerviewrefresh.R;
import com.example.fly.recyclerviewrefresh.pojo.ItemVo;
import com.trecyclerview.holder.AbsViewHolder;
import com.trecyclerview.holder.BaseHolder;

import java.util.Random;

/**
 */
public class StageredItemType extends AbsViewHolder<ItemVo, StageredItemType.ViewHolder> {
    public StageredItemType(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.type_1;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ItemVo item) {
        int h = new Random().nextInt(180)+260;
        holder.rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,h));
   holder.tv_type.setText(item.type);
    }

    static class ViewHolder extends BaseHolder {

        RelativeLayout rootView;
        TextView tv_type;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = getViewById(R.id.rl_root_view);
            tv_type = getViewById(R.id.tv_type);
        }

    }

}
