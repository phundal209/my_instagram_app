package rest;

import rx.Observable;

public interface IAsyncFactory {
    <T> Observable<T> createObservable(Observable.OnSubscribe<T> onSubscribe);
}
