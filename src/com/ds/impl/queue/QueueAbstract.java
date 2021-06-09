package com.ds.impl.queue;

public interface QueueAbstract {
    public Object dequeue();
    public void enqueue(Object object);
    public Object getFront();
    public Object getRear();
    public String toString();
    public boolean isFull();
    public boolean isEmpty();

}
