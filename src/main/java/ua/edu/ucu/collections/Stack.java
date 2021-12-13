package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList ll;

    public Stack() {
        this.ll = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.ll = ll.add(e);

    }

    public Object pop() {
        Object toReturn = this.ll.getLast();
        this.ll = this.ll.removeLast();
        return toReturn;
    }

    public Object peek() {
        return this.ll.getLast();
    }
}
