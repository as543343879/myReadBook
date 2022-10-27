package com.designPatterns.strategy.o2;

public interface ShopRankHandler {
    /**
    * 获取店铺类型的方法，接口的实现类需要根据各自的枚举类型来实现，后面就不贴出实现类的代码
    * @return 店铺等级
    */
    String getType();
    /**
    * 计算店铺等级
    * @return 店铺等级
    */
    String calculate();
}