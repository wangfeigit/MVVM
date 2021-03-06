package com.fly.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.fly.multitype.AbsItemView;

/**
 * @author：tqzhang on 18/7/13 16:47
 */
public abstract class AbsFootView<T, VH extends RecyclerView.ViewHolder> extends AbsItemView {

    protected Context mContext;

    public AbsFootView(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {
        onBindHolder((VH) holder, (T) item);
    }

    protected abstract void onBindHolder(@NonNull VH holder, @NonNull T mFootData);
}
