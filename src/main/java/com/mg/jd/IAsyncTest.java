package com.mg.jd;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * IAsyncTest class
 *
 * @author 谢小平
 * @date 2018/7/10
 */
public class IAsyncTest {
    public static void main(String[] args) {
        CompletableFuture<String> future = IAsyncTest.getHttpData("https://www.jd.com");
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = IAsyncTest.getHttpData("https://www.jd.com");
        String result = future.get();
        System.out.println(result);
    }

    public static HttpAsyncClient httpAsyncClient;
    public static CompletableFuture <String> getHttpData(String url) {
        CompletableFuture asyncFuture = new CompletableFuture();

        HttpAsyncRequestProducer asyncRequester =  HttpAsyncMethods.create(new HttpPost(url));
        BasicAsyncResponseConsumer  consumer = new BasicAsyncResponseConsumer();

        FutureCallback callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse o) {
                asyncFuture.complete(o);
            }

            @Override
            public void failed(Exception e) {
                asyncFuture.completeExceptionally(e);
            }

            @Override
            public void cancelled() {
                asyncFuture.cancel(true);
            }
        };
        httpAsyncClient.execute(asyncRequester, consumer, callback);
        return  asyncFuture;


    }
}
