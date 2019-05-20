package com.hb.rxjavademo.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.hb.rxjavademo.activity.CommonFragmentActivity;
import com.hb.rxjavademo.fragment.CreateFragment;
import com.hb.rxjavademo.fragment.MergeFragment;
import com.hb.rxjavademo.fragment.TransformFragment;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 11:31
 * 操作符ViewModel
 */
public class OperatorViewModel extends ViewModel {

    /**
     * 跳转创建操作符
     */
    public void startCreate(View view) {
        CommonFragmentActivity.start(view.getContext(), CreateFragment.class, null);
    }

    /**
     * 跳转转换操作符
     */
    public void startTransform(View view) {
        CommonFragmentActivity.start(view.getContext(), TransformFragment.class, null);
    }

    /**
     * 合并操作符
     */
    public void startMerge(View view) {
        CommonFragmentActivity.start(view.getContext(), MergeFragment.class, null);
    }
}
