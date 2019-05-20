package com.hb.rxjavademo.viewmodel;

import android.view.View;

import io.reactivex.Observable;

/**
 * @author huangbiao
 * @data 2019 2019-05-20 22:12
 * 合并操作符
 */
public class MergeOperatorViewModel extends BaseViewModel {

    /**
     * 使用场景，比如说多个接口后，刷新界面
     *
     * @param view
     */
    public void merge(View view) {
        Observable.merge(createObservable(), createObservable())
                .subscribe(getObserver());

    }


}
