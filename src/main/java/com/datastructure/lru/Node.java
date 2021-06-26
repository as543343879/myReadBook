package com.datastructure.lru;

import java.sql.Timestamp;

/**
 * Node class
 *
 * @author 格林
 * @date 2021-06-21
 */
public class Node<T> {
    private T value;
    private Timestamp timestamp;

    public Node(T value, Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
