package com.mg.java8.chapter06;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;
/**
 * Main class
 *
 * @author 谢小平
 * @date 2018/7/18
 */
public class Main {
    @Test
    public void test1() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDis = Dish.menu.stream().collect(maxBy(dishComparator));
        System.out.println(mostCalorieDis.get());
    }

    @Test
    public void test2 () {
       int mostCalorieDis = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(mostCalorieDis);
    }

    @Test
    public void test3() {
        Map<Dish.Type, List<Dish>> disTypeListMap = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(disTypeListMap);
        Map<String, List<Dish>> disTypeListMap2 = Dish.menu.stream().collect(groupingBy(Dish::getName));
        System.out.println(disTypeListMap2);
    }
    @Test
    public void test4() {
//        Collector
    }
}
