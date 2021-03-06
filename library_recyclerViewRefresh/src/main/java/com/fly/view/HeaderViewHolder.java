package com.fly.view;

import android.content.Context;
import android.view.View;

import com.fly.listener.OnTouchMoveListener;

/**
 */
public class HeaderViewHolder extends AbsHeaderView {

    public HeaderViewHolder(Context context, View view, OnTouchMoveListener onTouchMoveListener) {
        super(context, view,onTouchMoveListener);
    }

    public HeaderViewHolder(Context context, int progressStyle) {
        super(context, progressStyle);
    }

    @Override
    protected ArrowRefreshHeader createRefreshHeader() {
        ArrowRefreshHeader mRefreshHeader;
        if (mView != null) {
            mRefreshHeader = new ArrowRefreshHeader(mContext, mView);
            if (mOnTouchMoveListener != null) {
                mRefreshHeader.setOnTouchMoveListener(mOnTouchMoveListener);
            }
        } else {
            mRefreshHeader = new ArrowRefreshHeader(mContext);
            mRefreshHeader.setProgressStyle(mProgressStyle);
        }
        return mRefreshHeader;
    }
}
