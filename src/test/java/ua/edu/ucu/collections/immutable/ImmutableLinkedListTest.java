package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableLinkedListTest {
    private ImmutableLinkedList ll;
    private ImmutableLinkedList emptyLl;

    @BeforeEach
    void setUp() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        node1.setNext(node2);
        ImmutableLinkedList ll = new ImmutableLinkedList(node1);
        this.ll = ll;
        this.emptyLl = new ImmutableLinkedList();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void print() {

    }

    @Test
    void add() {
        ImmutableLinkedList ll1 = this.ll.add(4);
        Object[] expectedArr = new Object[]{1,2,3,4};
        assertArrayEquals(expectedArr, ll1.toArray());
    }

    @Test
    void testAdd() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void toArray() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void getHead() {
    }

    @Test
    void getTail() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }
}