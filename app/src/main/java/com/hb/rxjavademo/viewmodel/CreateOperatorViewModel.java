package com.hb.rxjavademo.viewmodel;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.hb.rxjavademo.model.OperatorModel;
import com.hb.rxjavademo.utils.DataUtil;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 12:54
 * 创建操作符ViewModel
 */
public class CreateOperatorViewModel extends BaseViewModel {

    private static final String TAG = CreateOperatorViewModel.class.getSimpleName();

    public void create(View view) {
        createObservable().subscribe(getObserver());
        createObservable().subscribe(getConsumer());
    }

    public void just(View view) {
        Observable.just("hello", "world")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Logger.d(s);
                    }
                });
    }

    public void fromIterable(View v) {
        Observable.fromIterable(DataUtil.createList())
                .subscribe(getConsumer());
    }

    public void timer(View view) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Logger.d("onSubscribe:" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Logger.d("onNext:" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(TAG, e);
                    }

                    @Override
                    public void onComplete() {
                        Logger.d("onComplete.");
                    }
                });
    }

    public void fromArray(View view) {
        Observable.fromArray(DataUtil.createArray())
                .subscribe(getObserver());
    }

    public void interval(View view) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(getObserver());
    }

    /**
     * 从5开始，总共发送10个onNext
     *
     * @param view
     */
    public void intervalRange(View view) {
        Observable.intervalRange(5, 10, 0, 1, TimeUnit.SECONDS)
                .subscribe(getObserver());
    }

    /**
     * 指定范围发送，于intervalRange不同的是，range不能指定延迟
     *
     * @param view
     */
    public void range(View view) {
        Observable.range(-9, 3)
                .subscribe(getObserver());
    }

}
