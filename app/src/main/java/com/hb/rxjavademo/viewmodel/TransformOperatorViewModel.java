package com.hb.rxjavademo.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.hb.rxjavademo.model.OperatorModel;
import com.hb.rxjavademo.utils.DataUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author huangbiao
 * @data 2019 2019-05-18
 * 转换操作符ViewModel
 */
public class TransformOperatorViewModel extends BaseViewModel {

    private static final String TAG = TransformOperatorViewModel.class.getSimpleName();

    public void map(View view) {
//        createObservable().map(new Function<OperatorModel, String>() {
//            @Override
//            public String apply(OperatorModel operatorModel) throws Exception {
//                return operatorModel.getInfo();
//            }
//        }).subscribe(getObserver());

        Observable.just(DataUtil.createArray())
                .map(new Function<OperatorModel[], String>() {
                    @Override
                    public String apply(OperatorModel[] operatorModels) throws Exception {
                        return "text";
                    }
                })
                .subscribe(getObserver());
    }

    public void flatMap(View view) {
        Observable.fromArray(DataUtil.createArray())
                .flatMap(new Function<OperatorModel, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(OperatorModel operatorModel) throws Exception {
                        return Observable.just(operatorModel.getInfo() + "-----");
                    }
                })
                .subscribe(getObserver());
    }

    public void concatMap(View view) {
        Observable.fromArray(DataUtil.createArray())
                .concatMap(new Function<OperatorModel, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(OperatorModel operatorModel) throws Exception {
                        return Observable.just(operatorModel.getInfo() + "-----");
                    }
                })
                .subscribe(getObserver());
    }

    /**
     * 其实就是将要发射的数据封装成多个缓冲区，每次发射一个缓冲区
     *
     * @param view
     */
    public void buffer(View view) {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .buffer(2) //每次发送两个数据，步长默认为1
                .subscribe(getObserver());
    }


}
