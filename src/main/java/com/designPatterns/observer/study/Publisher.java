package com.designPatterns.observer.study;

public interface Publisher {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notify(double amt);
}