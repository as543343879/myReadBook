package com.jdk8.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

/**
 * 发生异常时，根据是否为业务异常打印日志。
 * 跟CompletableFuture.whenComplete配合使用，不改变completableFuture的结果（正常OR异常）
 */
@Slf4j
public class LogErrorAction<R> extends AbstractLogAction<R> implements BiConsumer<R, Throwable> {
    public LogErrorAction(String methodName, Object... args) {
        super(methodName, args);
    }

    @Override
    public void accept(R result, Throwable throwable) {
        logResult(result, throwable);
    }
}