package com.ds.impl.queue;

import com.ds.impl.array.Array;

public class Queue implements QueueAbstract {
    private int front = 0;
    private int rear = -1;
    private final Array queue;
    private int size = 0;
    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Array(capacity);
    }

    @Override
    public void enqueue(Object object) {
        if (isFull()) {
            throw new QueueIndexOutOfBoundsException("Oh! Come on, Queue reached it's capacity, you can't add more than " + capacity + " in this Queue");
        }
        rear = (rear + 1) % capacity;
//        queue[rear] = object;
        queue.add(rear,object);
        size++;
        System.out.println(this);
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new QueueIndexOutOfBoundsException("Cannot dequeue from empty queue");
        }
//        Object temp = queue[front];
        Object temp = queue.get(front);
//        queue[front] = null;
        queue.add(front,null);
        front = (front + 1) % capacity;
        size--;
        System.out.println(this);
        return temp;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            throw new QueueIndexOutOfBoundsException("If there is nothing in Queue, How can you get front value?");
        }
        return front;
    }

    @Override
    public Object getRear() {
        if (isEmpty()) {
            throw new QueueIndexOutOfBoundsException("If there is nothing in Queue, How can you get rear value?");
        }
        return rear;
    }

    @Override
    public String toString() {
        String strQueue = "[ ";
        if (isEmpty()) {
            return "[]";
        }
        int i = front;
        while (i != rear) {
//            strQueue += queue[i] + ", ";
            strQueue += queue.get(i) + ", ";
            i = (i + 1) % capacity;
        }
//        strQueue += queue[rear] + " ]";
        strQueue += queue.get(rear) + " ]";
        return strQueue;
    }

    @Override
    public boolean isFull() {
        return (size == capacity);
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
