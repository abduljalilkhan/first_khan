package com.example.githubmvvm.Utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import org.jetbrains.annotations.NotNull;

public class LiveDataUtil {
    public static <T> void observeOnce(final LiveData<T> liveData, final Observer<T> observer) {
        liveData.observeForever(new Observer<T>() {
            @Override
            public void onChanged(T t) {
                liveData.removeObserver(this);
                observer.onChanged(t);
            }
        });

    }

    public static <T>  void observeOnceWithLifeCycle( final LiveData<T> liveData,  LifecycleOwner lifecycleOwner,  final Observer<T> observer) {

        liveData.observe(lifecycleOwner, new Observer<T>() {
            public void onChanged(T value) {
                observer.onChanged(value);
                liveData.removeObserver(observer);
            }
        });
    }
//    public static  void observeOnceWithLifeCycle( final LiveData liveData,  LifecycleOwner lifecycleOwner,  final Observer observer) {
//
//        liveData.observe(lifecycleOwner, new Observer() {
//            public void onChanged(Object value) {
//                observer.onChanged(value);
//                liveData.removeObserver(observer);
//            }
//        });
//    }

}
