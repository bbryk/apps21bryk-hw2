package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    public ImmutableLinkedList ll;

    public Queue() {
        this.ll = new ImmutableLinkedList();

    }

    public Object peek() {
        return this.ll.getFirst();
    }

    public Object dequeue() {
        Object toReturn = this.ll.getFirst();
        this.ll = this.ll.removeFirst();
        return toReturn;
    }

    public void enqueue(Object e) {
        this.ll = ll.add(e);
    }


}
