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
        Object[] expectedArr = new Object[]{1, 2, 3, 4};
        assertArrayEquals(expectedArr, ll1.toArray());


        expectedArr = new Object[]{5};
        ImmutableLinkedList ll2 = this.emptyLl.add(5);
        assertArrayEquals(expectedArr, ll2.toArray());

    }

    @Test
    void testAdd() {
        ImmutableLinkedList ll1 = this.ll.add(2, 50);

        Object[] expectedArr = new Object[]{1, 2, 50, 3};
        assertArrayEquals(expectedArr, ll1.toArray());

        ImmutableLinkedList ll2 = this.emptyLl.add(0, 5);
        expectedArr = new Object[]{5};
        assertArrayEquals(expectedArr, ll2.toArray());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.add(2, 80085);
        });
    }

    @Test
    void addAll() {
        Object[] toAdd = new Object[]{5, 5};

        ImmutableLinkedList ll1 = this.ll.addAll(toAdd);
        Object[] expectedArr = new Object[]{1, 2, 3, 5, 5};
        assertArrayEquals(expectedArr, ll1.toArray());

        ImmutableLinkedList ll2 = this.emptyLl.addAll(toAdd);
        expectedArr = new Object[]{5, 5};
        assertArrayEquals(expectedArr, ll2.toArray());

    }

    @Test
    void testAddAll() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.add(2, new Object[]{1, 2, 3});
        });

        ImmutableLinkedList ll1 = this.ll.addAll(2, new Object[]{50, 60});
        Object[] expectedArr = new Object[]{1, 2, 50, 60, 3};
        assertArrayEquals(expectedArr, ll1.toArray());

    }

    @Test
    void get() {
        Object expected = 3;
        assertEquals(expected, this.ll.get(2));
    }

    @Test
    void remove() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.remove(5);
        });
        ImmutableLinkedList ll1 = this.ll.remove(2);
        Object[] expectedArr = new Object[]{1, 2};
        assertArrayEquals(expectedArr, ll1.toArray());
    }

    @Test
    void set() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.set(5, 5);
        });
        ImmutableLinkedList ll1 = this.ll.set(1, 6);
        Object[] expectedArr = new Object[]{1, 6, 3};
        assertArrayEquals(expectedArr, ll1.toArray());

        ImmutableLinkedList ll2 = this.emptyLl.set(0, 6);
        Object[] expectedArr1 = new Object[]{6};
        assertArrayEquals(expectedArr1, ll2.toArray());

    }

    @Test
    void indexOf() {
        int expected = 2;
        assertEquals(expected, this.ll.indexOf(3));
        expected = 0;
        assertEquals(expected, this.ll.indexOf(5));


    }

    @Test
    void size() {
        int expected = 0;
        assertEquals(expected, this.emptyLl.size());
        expected = 3;
        assertEquals(expected, this.ll.size());
    }

    @Test
    void clear() {
        assertArrayEquals(this.emptyLl.toArray(), this.ll.clear().toArray());
    }

    @Test
    void isEmpty() {

        assertTrue(emptyLl.isEmpty());
    }

    @Test
    void toArray() {
        Object[] arr = new Object[]{1, 2, 3};
        assertArrayEquals(arr, this.ll.toArray());
    }

    @Test
    void addFirst() {
        ImmutableLinkedList ll1 = this.emptyLl.addFirst(5);
        Object[] expected = new Object[]{5};
        assertArrayEquals(expected, ll1.toArray());

        ImmutableLinkedList ll2 = this.ll.addFirst(5);
        expected = new Object[]{5, 1, 2, 3};
        assertArrayEquals(expected, ll2.toArray());

    }

    @Test
    void addLast() {
        ImmutableLinkedList ll1 = this.emptyLl.addLast(5);
        Object[] expected = new Object[]{5};
        assertArrayEquals(expected, ll1.toArray());

        ImmutableLinkedList ll2 = this.ll.addLast(5);
        expected = new Object[]{1, 2, 3, 5};
        assertArrayEquals(expected, ll2.toArray());


    }

    @Test
    void getHead() {
        Node expected = new Node(1);
        assertEquals(expected.getValue(), this.ll.getHead().getValue());

    }

    @Test
    void getTail() {
        Node expected = new Node(3);
        assertEquals(expected.getValue(), this.ll.getTail().getValue());
    }

    @Test
    void getFirst() {
        int expected = 1;
        assertEquals(expected, this.ll.getFirst());

    }

    @Test
    void getLast() {
        int expected = 3;
        assertEquals(expected, this.ll.getLast());
    }

    @Test
    void removeFirst() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.removeFirst();
        });
        ImmutableLinkedList ll1 = this.ll.removeFirst();
        Object[] expected = new Object[]{2, 3};
        assertArrayEquals(expected, ll1.toArray());
    }

    @Test
    void removeLast() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.removeLast();
        });
        ImmutableLinkedList ll1 = this.ll.removeLast();
        Object[] expected = new Object[]{1, 2};
        assertArrayEquals(expected, ll1.toArray());
    }
}