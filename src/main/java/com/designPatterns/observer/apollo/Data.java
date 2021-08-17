package com.designPatterns.observer.apollo;


import lombok.experimental.Accessors;

/**
 * Data class
 * 配置文件实体
 * @author 谢小平
 * @date 2021/8/17
 */
@Accessors(chain = true)
@lombok.Data
public class Data {
    private Long id;
    private String name;
    private String data;
}
