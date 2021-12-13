package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ImmutableLinkedListTest {
    private ImmutableLinkedList ll;
    private ImmutableLinkedList emptyLl;


    @Before
    public void setUp() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});
    }




    @Test
    public void add() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        ImmutableLinkedList ll1 = this.ll.add(4);
        Object[] expectedArr = new Object[]{1, 2, 3, 4};
        assertArrayEquals(expectedArr, ll1.toArray());


        expectedArr = new Object[]{5};
        ImmutableLinkedList ll2 = this.emptyLl.add(5);
        assertArrayEquals(expectedArr, ll2.toArray());

    }

    @Test
    public void testAdd() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});
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
    public void addAll() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Object[] toAdd = new Object[]{5, 5};

        ImmutableLinkedList ll1 = this.ll.addAll(toAdd);
        Object[] expectedArr = new Object[]{1, 2, 3, 5, 5};
        assertArrayEquals(expectedArr, ll1.toArray());

        ImmutableLinkedList ll2 = this.emptyLl.addAll(toAdd);
        expectedArr = new Object[]{5, 5};
        assertArrayEquals(expectedArr, ll2.toArray());

    }

    @Test
    public void testAddAll() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.add(2, new Object[]{1, 2, 3});
        });

        ImmutableLinkedList ll1 = this.ll.addAll(2, new Object[]{50, 60});
        Object[] expectedArr = new Object[]{1, 2, 50, 60, 3};
        assertArrayEquals(expectedArr, ll1.toArray());

    }

    @Test
    public void get() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Object expected = 3;
        assertEquals(expected, this.ll.get(2));
    }

    @Test
    public void remove() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.remove(5);
        });
        ImmutableLinkedList ll1 = this.ll.remove(2);
        Object[] expectedArr = new Object[]{1, 2};
        assertArrayEquals(expectedArr, ll1.toArray());
    }

    @Test
    public void set() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

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
    public void indexOf() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        int expected = 2;
        assertEquals(expected, this.ll.indexOf(3));
        expected = 0;
        assertEquals(expected, this.ll.indexOf(5));


    }

    @Test
    public void size() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        int expected = 0;
        assertEquals(expected, this.emptyLl.size());
        expected = 3;
        assertEquals(expected, this.ll.size());
    }

    @Test
    public void clear() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        assertArrayEquals(this.emptyLl.toArray(), this.ll.clear().toArray());
    }

    @Test
    public void isEmpty() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        assertTrue(emptyLl.isEmpty());
    }

    @Test
    public void toArray() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Object[] arr = new Object[]{1, 2, 3};
        assertArrayEquals(arr, this.ll.toArray());
    }

    @Test
    public void addFirst() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        ImmutableLinkedList ll1 = this.emptyLl.addFirst(5);
        Object[] expected = new Object[]{5};
        assertArrayEquals(expected, ll1.toArray());

        ImmutableLinkedList ll2 = this.ll.addFirst(5);
        expected = new Object[]{5, 1, 2, 3};
        assertArrayEquals(expected, ll2.toArray());

    }

    @Test
    public void addLast() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        ImmutableLinkedList ll1 = this.emptyLl.addLast(5);
        Object[] expected = new Object[]{5};
        assertArrayEquals(expected, ll1.toArray());

        ImmutableLinkedList ll2 = this.ll.addLast(5);
        expected = new Object[]{1, 2, 3, 5};
        assertArrayEquals(expected, ll2.toArray());


    }

    @Test
    public void getHead() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Node expected = new Node(1);
        assertEquals(expected.getValue(), this.ll.getHead().getValue());

    }

    @Test
    public void getTail() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});
        Node expected = new Node(3);
        assertEquals(expected.getValue(), this.ll.getTail().getValue());
    }

    @Test
    public void getFirst() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        int expected = 1;
        assertEquals(expected, this.ll.getFirst());

    }

    @Test
    public void getLast() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        int expected = 3;
        assertEquals(expected, this.ll.getLast());
    }

    @Test
    public void removeFirst() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.removeFirst();
        });
        ImmutableLinkedList ll1 = this.ll.removeFirst();
        Object[] expected = new Object[]{2, 3};
        assertArrayEquals(expected, ll1.toArray());
    }

    @Test
    public void removeLast() {
        this.emptyLl = new ImmutableLinkedList();
        this.ll = new ImmutableLinkedList(new Object[]{1, 2, 3});

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.emptyLl.removeLast();
        });
        ImmutableLinkedList ll1 = this.ll.removeLast();
        Object[] expected = new Object[]{1, 2};
        assertArrayEquals(expected, ll1.toArray());
    }
}