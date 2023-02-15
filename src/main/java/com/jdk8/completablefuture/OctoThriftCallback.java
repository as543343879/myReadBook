package com.jdk8.completablefuture;

public interface OctoThriftCallback<R, T> {
        void addObserver(OctoObserver<T> octoObserver);
    }