package com.designPatterns.strategy.o1;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HandlerFactory<E, T extends GenericInterface<E>> implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    /**
     * 泛型策略接口类型
     */
    private Class<T> strategyInterfaceType;

    /**
     * java泛型只存在于编译期，无法通过例如T.class的方式在运行时获取其类信息
     * 因此利用构造函数传入具体的策略类型class对象为getBeansOfType()方法
     * 提供参数
     *
     * @param strategyInterfaceType 要传入的策略接口类型
     */
    public HandlerFactory(Class<T> strategyInterfaceType) {
        this.strategyInterfaceType = strategyInterfaceType;
    }
    /**
     * 策略实例容器
     */
    private Map<E, T> GET_SHOP_RANK_STRATEGY_MAP;
    /**
     * 根据不同参数类型获取对应的接口实现类
     *
     * @param type 参数类型
     * @return 参数类型对应的接口实现类
     */
    public T getStrategy(E type) {
        return GET_SHOP_RANK_STRATEGY_MAP.get(type);
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, T> beansOfType = applicationContext.getBeansOfType(strategyInterfaceType);
        System.out.println(beansOfType);

        GET_SHOP_RANK_STRATEGY_MAP = Optional.ofNullable(beansOfType)
                .map(beansOfTypeMap -> beansOfTypeMap.values().stream()
                        .filter(strategy -> StringUtils.isNotEmpty(strategy.getType().toString()))
                        .collect(Collectors.toMap(strategy -> strategy.getType(), Function.identity())))
                .orElse(new HashMap<>(8));
        System.out.println(GET_SHOP_RANK_STRATEGY_MAP);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}