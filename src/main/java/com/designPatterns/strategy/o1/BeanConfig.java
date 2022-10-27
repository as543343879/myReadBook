package com.designPatterns.strategy.o1;

import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean
    public HandlerFactory<String, StrategyInterfaceA> strategyInterfaceAFactory(){
        return new HandlerFactory<>(StrategyInterfaceA.class);
    }
    @Bean
    public HandlerFactory<Integer, StrategyInterfaceB> strategyInterfaceBFactory(){
        return new HandlerFactory<>(StrategyInterfaceB.class);
    }
    @Bean
    public HandlerFactory<Long, StrategyInterfaceC> strategyInterfaceCFactory(){
        return new HandlerFactory<>(StrategyInterfaceC.class);
    }
  
}