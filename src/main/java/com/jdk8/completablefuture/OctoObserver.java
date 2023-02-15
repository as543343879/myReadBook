package com.jdk8.completablefuture;

public interface OctoObserver<T> {
        void onSuccess(T t);
        void onFailure(Throwable throwable );
    }