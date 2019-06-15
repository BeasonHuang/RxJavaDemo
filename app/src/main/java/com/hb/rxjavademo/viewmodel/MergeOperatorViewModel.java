package com.hb.rxjavademo.viewmodel;

import android.util.Log;
import android.view.View;

import com.hb.rxjavademo.model.OperatorModel;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.schedulers.Schedulers;

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

    /**
     * 无序
     *
     * @param view
     */
    public void mergeArray(View view) {
        Observable.mergeArray(createObservable(), createObservable(), createObservable(), createObservable(), createObservable())
                .subscribe(getObserver());
    }

    /**
     * 有序
     *
     * @param view
     */
    public void concat(View view) {
        Observable.concat(createObservable(), createObservable2())
                .subscribe(getObserver());
    }

    /**
     * 有序
     *
     * @param view
     */
    public void concatArray(View view) {
        Observable.concat(createObservable(), createObservable())
                .subscribe(getObserver());
    }


    public void zip(View view) {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e("TAG", "emit 1");
                emitter.onNext(1);
                Thread.sleep(1000);

                Log.e("TAG", "emit 2");
                emitter.onNext(2);
                Thread.sleep(1000);

                Log.e("TAG", "emit 3");
                emitter.onNext(3);
                Thread.sleep(1000);

                Log.e("TAG", "emit 4");
                emitter.onNext(4);
                Thread.sleep(1000);

                Log.e("TAG", "emit complete1");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());    // 让上游1（第一个水管）在子线程中执行


        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.e("TAG", "emit A");
                emitter.onNext("A");
                Thread.sleep(1000);

                Log.e("TAG", "emit B");
                emitter.onNext("B");
                Thread.sleep(1000);

                Log.e("TAG", "emit C");
                emitter.onNext("C");
                Thread.sleep(1000);

                Log.e("TAG", "emit complete2");
                emitter.onComplete();

            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, Object>() {
            @Override
            public Object apply(Integer integer, String s) throws Exception {
                return integer;
            }
        })
                .subscribe(getObserver());
    }

    public void combineLatest(View view) {
        Observable.combineLatest(createObservable(), createObservable2(), new BiFunction<OperatorModel, OperatorModel, String>() {
            @Override
            public String apply(OperatorModel operatorModel, OperatorModel operatorModel2) throws Exception {

                return operatorModel.toString() + operatorModel2.toString();
            }
        })
                .subscribe(getObserver());
    }


    public void reduce(View view) {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Logger.d("apply:" + integer);
                        Logger.d("apply2:" + integer2);
                        return integer2 * 10;
                    }

                }).subscribe(getConsumer());
    }


    public void startWith(View view) {
        Observable.just(1, 2, 3)
                .startWith(4)
                .subscribe(getObserver());
    }

    public void count(View view) {
        Observable.just(1, 2, 3, 4, 5)
                .count()
                .subscribe(getConsumer());
    }
}
