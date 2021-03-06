package com.example.fly.mvvm.core.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fly.mvvm.AdapterPool;
import com.example.fly.mvvm.base.BaseListFragment;
import com.example.fly.mvvm.config.Constants;
import com.example.fly.mvvm.core.bean.pojo.banner.BannerListVo;
import com.example.fly.mvvm.core.bean.pojo.common.TypeVo;
import com.example.fly.mvvm.core.bean.pojo.course.CourseRemVo;
import com.example.fly.mvvm.core.vm.CourseViewModel;
import com.trecyclerview.multitype.MultiTypeAdapter;
import com.trecyclerview.pojo.HeaderVo;

/**
 */
public class CourseRecommendFragment extends BaseListFragment<CourseViewModel> {
    public static CourseRecommendFragment newInstance() {
        return new CourseRecommendFragment();
    }

    @Override
    public void initView(Bundle state) {
        super.initView(state);
    }

    @Override
    protected void dataObserver() {
        mViewModel.getCourseRemList().observe(this, courseRemVo -> {
            if (courseRemVo != null) {
                setData(courseRemVo);
            }

        });
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        GridLayoutManager layoutManager = new GridLayoutManager(activity, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return oldItems.get(position) instanceof TypeVo
                        || oldItems.get(position) instanceof BannerListVo
                        || oldItems.get(position) instanceof HeaderVo ?
                        2 : 1;
            }
        });
        return layoutManager;
    }

    @Override
    protected MultiTypeAdapter createAdapter() {
        return AdapterPool.newInstance().getCourseRemAdapter(activity);
    }

    @Override
    protected void onStateRefresh() {
        super.onStateRefresh();
        getRemoteData();
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        getRemoteData();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        getRemoteData();
    }

    @Override
    protected void getRemoteData() {
        mViewModel.getCourseRemList(Constants.PAGE_RN);
    }


    private void setData(CourseRemVo courseRemVo) {
        if (courseRemVo.data.top_adv != null) {
            setBannerData(new BannerListVo(courseRemVo.data.top_adv));
        }
        for (int i = 0; i < courseRemVo.data.course_recommend.size(); i++) {
            newItems.add(new TypeVo(courseRemVo.data.course_recommend.get(i).f_catalog + "/" + courseRemVo.data.course_recommend.get(i).s_catalog));
            newItems.addAll(courseRemVo.data.course_recommend.get(i).course_list);
        }
        oldItems.clear();
        oldItems.addAll(newItems);
        mRecyclerView.refreshComplete(oldItems,true);
        newItems.clear();
    }


}
