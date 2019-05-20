package com.hb.rxjavademo.viewmodel;

import androidx.lifecycle.ViewModel;

import com.hb.rxjavademo.model.OperatorModel;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author huangbiao
 * @data 2019 2019-05-19 23:03
 */
public class BaseViewModel extends ViewModel {


    protected Observable<OperatorModel> createObservable() {
        return Observable.create(new ObservableOnSubscribe<OperatorModel>() {
            @Override
            public void subscribe(ObservableEmitter<OperatorModel> emitter) throws Exception {
                emitter.onNext(new OperatorModel("onNext1"));
                emitter.onNext(new OperatorModel("onNext2"));
                emitter.onComplete();
                emitter.onNext(new OperatorModel("onNext3"));
            }
        });
    }


    /**
     * Consumer参数的方法表示下游只关心onNext事件,onCompleted时间忽略，之后时间不被接受
     *
     * @return
     */
    protected Consumer getConsumer() {
        return new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Logger.d("accept:" + o);
            }
        };
    }

    protected Observer<Object> getObserver() {
        return new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Logger.d("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Logger.d("next:" + o);
            }

            @Override
            public void onError(Throwable e) {
                Logger.e("error:", e);
            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
            }
        };
    }
}
