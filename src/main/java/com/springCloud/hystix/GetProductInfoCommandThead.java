package com.springCloud.hystix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.springCloud.hystix.dto.ProductInfo;

public class GetProductInfoCommandThead extends HystrixCommand<ProductInfo> {

    private Long productId;
    private long sheep = 1000 * 10L;
    public GetProductInfoCommandThead(Long productId) {
//        super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoCommandGroup"));

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetCityNameGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                )
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withMaxQueueSize(10)
                        .withCoreSize(7)
                        .withMaximumSize(10)
                        .withQueueSizeRejectionThreshold(7)

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