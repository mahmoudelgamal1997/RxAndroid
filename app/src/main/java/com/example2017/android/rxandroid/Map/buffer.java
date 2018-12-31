package com.example2017.android.rxandroid.Map;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by M7moud on 27-Dec-18.
 */
public class buffer {
    // when buffer = 3 then emits 3 item in onnext each time
/*
    Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4,
            5, 6, 7, 8, 9);

    integerObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .buffer(3)
    .subscribe(new Observer<List<Integer>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Integer> integers) {
            System.out.println("on Next");
            for (Integer integer : integers) {
                Log.d("ss", "Item: " + integer);
            }
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            Log.d("ss", "All items emitted!");
        }
    });

*/
}
