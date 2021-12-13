package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;
    private int capacity;
    private int actualSize;

    @Override
    public String toString() {
        return "ImmutableArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", capacity=" + capacity +
                ", actualSize=" + actualSize +
                '}';
    }

    public ImmutableArrayList(Object[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.capacity = elements.length;
        this.actualSize = elements.length;
    }

    public ImmutableArrayList() {
        this.elements = new Object[]{};
        this.capacity = 0;
        this.actualSize = 0;
    }

    public Object[] resize(int addSize) {
        Object[] newElements = new Object[this.capacity + addSize];
        for (int i = 0; i < this.actualSize; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }

    public static Object[] move(int index, Object[] arr, int addSize) {
        Object[] newElements = new Object[arr.length + addSize];
        for (int i = 0; i < index; i++) {
            newElements[i] = arr[i];
        }
        for (int i = index; i < arr.length; i++) {
            newElements[i + addSize] = arr[i];
        }
        return newElements;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] newElements = this.resize(1);
        newElements[this.capacity] = e;
        return new ImmutableArrayList(newElements);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        // 1 2 3 4 5   9 on index 2
        // 1 2 9 3 4 5
        Object[] newElements = move(index, this.elements, 1);
        newElements[index] = e;


        return new ImmutableArrayList(newElements);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newElements = this.resize(c.length);
        for (int i = 0; i < c.length; i++) {
            newElements[this.capacity + i] = c[i];

        }
        return new ImmutableArrayList(newElements);

    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        Object[] newElements = move(index, this.elements, c.length);
        for (int i = 0; i < c.length; i++) {
            newElements[index + i] = c[i];

        }
        return new ImmutableArrayList(newElements);

    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        Object[] newElements = new Object[this.capacity - 1];
        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];

        }
        for (int i = index; i < this.capacity - 1; i++) {
            newElements[i] = this.elements[i + 1];
        }
        return new ImmutableArrayList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newElements = Arrays.copyOf(elements, elements.length);
        newElements[index] = e;
        return new ImmutableArrayList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.elements[i].equals(e)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int size() {
        return this.capacity;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.capacity == 0;
    }

    @Override
    public Object[] toArray() {
        return this.elements;
    }
}
