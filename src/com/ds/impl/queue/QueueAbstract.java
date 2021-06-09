package com.ds.impl.queue;

public interface QueueAbstract {
    Object dequeue();
    void enqueue(Object object);
    Object getFront();
    Object getRear();
    String toString();
    boolean isFull();
    boolean isEmpty();

}
