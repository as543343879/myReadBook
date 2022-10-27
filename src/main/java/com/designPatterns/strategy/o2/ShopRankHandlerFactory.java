package com.designPatterns.strategy.o2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ShopRankHandlerFactory implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;
    /**
     * 策略实例容器
     */
    private Map<String, ShopRankHandler> GET_SHOP_RANK_STRATEGY_MAP;

    /**
     * 根据店铺类型获取对应的获取店铺卡片实现类
     *
     * @param shopType 店铺类型
     * @return 店铺类型对应的获取店铺卡片实现类
     */
    public ShopRankHandler getStrategy(String shopType) {
        return GET_SHOP_RANK_STRATEGY_MAP.get(shopType);
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, ShopRankHandler> beansOfType = applicationContext.getBeansOfType(ShopRankHandler.class);

        GET_SHOP_RANK_STRATEGY_MAP = Optional.ofNullable(beansOfType)
                            .map(beansOfTypeMap -> beansOfTypeMap.values().stream()
                                    .filter(shopRankHandle -> StringUtils.isNotEmpty(shopRankHandle.getType()))
                                    .collect(Collectors.toMap(ShopRankHandler::getType, Function.identity())))
                            .orElse(new HashMap<>(8));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}