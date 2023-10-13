package com.springCloud.hystix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.springCloud.hystix.dto.ProductInfo;

public class GetProductInfoCommand extends HystrixCommand<ProductInfo> {

    private Long productId;
    private long sheep = 1 * 10L;
    public GetProductInfoCommand(Long productId) {
//        super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoCommandGroup"));

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetCityNameGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(7)
                        .withExecutionTimeoutInMilliseconds(1000 * 11  )
                )

        );


        this.productId = productId;
    }

    @Override
    protected ProductInfo run() {
        String url = "http://localhost:8081/getProductInfo?productId=" + productId;
        // 调用商品服务接口
        ProductInfo productInfo = new ProductInfo();
        productInfo.setName("iphone 12");
        try {
            Thread.sleep(sheep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productInfo ;
    }


    @Override
    protected ProductInfo getFallback() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setName("降级");
        return productInfo;
    }
}