package com.example.fly.mvvm.core.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.fly.mvvm.R;
import com.example.fly.mvvm.core.bean.pojo.material.MatreialSubjectVo;
import com.example.fly.mvvm.glide.GlideRoundTransform;
import com.example.fly.mvvm.utils.DisplayUtil;
import com.trecyclerview.holder.AbsViewHolder;
import com.trecyclerview.holder.BaseHolder;

/**
 */
public class HomeMaterialItemView extends AbsViewHolder<MatreialSubjectVo, HomeMaterialItemView.ViewHolder> {

    private int commonWidth ;
    public HomeMaterialItemView(Context context) {
        super(context);
        commonWidth= (int) (((float) DisplayUtil.getScreenWidth(mContext)
                - DisplayUtil.dp2px(mContext, 8)) / 2);
    }

    @Override
    public int getLayoutResId() {
//        return R.layout.home_matreial_item;
        return R.layout.item_home_list;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MatreialSubjectVo matreialsubject) {
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        holder.mRecyclerView.setLayoutManager(layoutManager);
//        HomeListAdapter adapter = new HomeListAdapter(mContext, null, 0);
//        holder.mRecyclerView.setAdapter(adapter);
//        holder.mRecyclerView.setNestedScrollingEnabled(false);
//        adapter.setList(matreialsubject.matreialsubject);
//        adapter.notifyDataSetChanged();
        float dv = (float) matreialsubject.picurl.l.h / (float) matreialsubject.picurl.l.w;
        int height = (int) (dv * commonWidth);
        holder.videoImg.setLayoutParams(new RelativeLayout.LayoutParams(commonWidth, height));
        Glide.with(mContext).load(matreialsubject.picurl.l.url)
                .placeholder(R.color.black_e8e8e8)
                .transform(new GlideRoundTransform(mContext, 4))
                .override(commonWidth, (int) (dv * commonWidth)).into(holder.videoImg);
        holder.videoTitle.setText(matreialsubject.title);
    }

    static class ViewHolder extends BaseHolder {

         CustomHeightImageView videoImg;
         TextView videoTitle;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImg = getViewById(R.id.iv_pic_image);
            videoTitle = getViewById(R.id.video_title);
        }

    }

}
