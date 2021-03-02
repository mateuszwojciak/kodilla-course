package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface Observable {
    void registerObserver(com.kodilla.patterns2.observer.homework.Observer observer);
    void notifyObservers();
    void removeObserver(com.kodilla.patterns2.observer.homework.Observer observer);
}
