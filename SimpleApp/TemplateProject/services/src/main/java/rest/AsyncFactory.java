package rest;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GoFundMe on 1/11/17.
 */

public class AsyncFactory implements IAsyncFactory {

    public <T> Observable<T> createObservable(Observable.OnSubscribe<T> onSubscribe) {
        return Observable.create(onSubscribe)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}