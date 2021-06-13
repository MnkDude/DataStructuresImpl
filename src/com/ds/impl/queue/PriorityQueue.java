package com.ds.impl.queue;

import com.ds.impl.array.Array;

public class PriorityQueue  {
    Array priorityQueue;
    int size = 0;
    int capacity;

    private class Item {
        int priority;
        Object object;

        public Item(Object object, int priority) {
            this.priority = priority;
            this.object = object;
        }
    }

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        priorityQueue = new Array(capacity);
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new QueueIndexOutOfBoundsException("Cannot dequeue from empty queue");
        }
        int index = getHighestPriority();
        Object temp = null;
        if (index != -1) {
            temp = priorityQueue.get(index);
            priorityQueue.add(index, null);
            size--;
        }

        return temp;
    }


    public void enqueue(Object object, int priority) {
        if (object == null) {
            throw new IllegalArgumentException(" null is never acceptable in PriorityQueue, don't ever do that ");
        }
        if (isFull()) {
            throw new QueueIndexOutOfBoundsException("Oh! Come on, Queue reached it's capacity, you can't add more than " + capacity + " in this Queue");
        }
        priorityQueue.add(new Item(object, priority));
        size++;
    }

    public int getHighestPriority() {
        int highest = Integer.MAX_VALUE;
        int index = -1;
        int i = 0;
        if (isEmpty()) {
            throw new QueueIndexOutOfBoundsException("If there is nothing in Queue, How can you get rear value?");
        }
        while (i < priorityQueue.size) {
            Item item = (Item) priorityQueue.get(i);
            if (item != null && item.priority < highest) {
                index = i;
                highest = item.priority;
            }
            i++;
        }
        return index;
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
