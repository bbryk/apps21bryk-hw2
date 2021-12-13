package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;

    public ImmutableLinkedList(Object[] elements) {
        Node newNead = new Node(elements[0]);
        Node current = newNead;
        for (int i = 1; i < elements.length; i++) {
            current.setNext(new Node(elements[i]));
            current = current.getNext();
        }
        this.head = newNead;

    }

    public ImmutableLinkedList(Node head) {
        this.head = head;

    }

    public ImmutableLinkedList() {
        this.head = null;

    }


    @Override
    public ImmutableLinkedList add(Object e) {
        Node newHead;
        if (head != null) {
            newHead = new Node(this.head.getValue());
            Node newCurrent = newHead;
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(new Node(current.getValue()));
                newCurrent = newCurrent.getNext();
            }


            Node newNode = new Node(e);


            newCurrent.setNext(newNode);
        } else {
            newHead = new Node(e);
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if ((index > this.size()) | (index < 0)) {
            throw new IllegalArgumentException();
        }
        if (index == 0 | head == null) {
            return this.addFirst(e);
        }

        Node newHead = new Node(this.head.getValue());


        Node newCurrent = newHead;
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }

        Node newNode = new Node(e);
        newCurrent.setNext(newNode);
        newCurrent = newNode;


        while (current.getNext() != null) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        Node newHead;
        if (head != null) {
            newHead = new Node(this.head.getValue());
            Node newCurrent = newHead;
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(new Node(current.getValue()));
                newCurrent = newCurrent.getNext();
            }

            for (int i = 0; i < c.length; i++) {
                Node newNode = new Node(c[i]);
                newCurrent.setNext(newNode);
                newCurrent = newCurrent.getNext();

            }
        } else {
            return new ImmutableLinkedList(c);
        }


        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if ((index > this.size()) | (index < 0)) {
            throw new IllegalArgumentException();
        } else if (head == null) {
            return new ImmutableLinkedList(c);
        }
        Node newHead = new Node(this.head.getValue());
        Node newCurrent = newHead;
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }
        for (int i = 0; i < c.length; i++) {
            Node newNode = new Node(c[i]);
            newCurrent.setNext(newNode);
            newCurrent = newCurrent.getNext();
        }

        while (current.getNext() != null) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public Object get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();

        }
        return current.getValue();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if ((index > this.size()) | (index < 0) | head == null) {
            throw new IllegalArgumentException();
        }
        Node newHead = new Node(this.head.getValue());
        Node newCurrent = newHead;
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }
        current = current.getNext();

        while (current.getNext() != null) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if ((index > this.size()) | (index < 0)) {
            throw new IllegalArgumentException();
        } else if (head == null) {
            return new ImmutableLinkedList(new Node(e));
        }
        Node newHead = new Node(this.head.getValue());
        Node newCurrent = newHead;
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }
        Node newNode = new Node(e);
        newCurrent.setNext(newNode);
        newCurrent = newNode;
        current = current.getNext();

        while (current.getNext() != null) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }

        return new ImmutableLinkedList(newHead);
    }

    @Override
    public int indexOf(Object e) {
        Node current = head;
        int i = 0;

        while (current != null) {
            if (current.getValue().equals(e)) {
                return i;
            }
            current = current.getNext();
            i++;

        }

        return 0;

    }

    @Override
    public int size() {
        Node current = head;
        if (head != null) {
            int i = 1;
            while (current.getNext() != null) {

                current = current.getNext();
                i++;

            }
            return i;
        }
        return 0;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size()];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i] = current.getValue();
            current = current.getNext();
            i++;

        }

        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node newHead;
        if (head != null) {
            Node newNode = new Node(e);
            newHead = newNode;
            Node newCurrent = newHead;
            Node current = head;
            newHead.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();

            while (current.getNext() != null) {
                current = current.getNext();
                newCurrent.setNext(new Node(current.getValue()));
                newCurrent = newCurrent.getNext();
            }
        } else {
            newHead = new Node(e);
        }


        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList addLast(Object e) {
        if (head == null) {
            return new ImmutableLinkedList(new Node(e));
        }
        return this.add(this.size(), e);

    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public Object getFirst() {
        return this.getHead().getValue();
    }

    public Object getLast() {
        return this.getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException();

        }

        Node newHead = new Node(this.head.getNext().getValue());
        Node newCurrent = newHead;
        Node current = head.getNext();
        while (current.getNext() != null) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
        }


        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList removeLast() {
        if (head == null) {
            throw new IllegalArgumentException();

        }

        Node newHead = new Node(this.head.getValue());
        Node newCurrent = newHead;
        Node current = head;
        if (current.getNext() == null) {
            return new ImmutableLinkedList();

        }
        int size = this.size();
        int i = 1;
        while (i != size - 1) {
            current = current.getNext();
            newCurrent.setNext(new Node(current.getValue()));
            newCurrent = newCurrent.getNext();
            i++;
        }


        return new ImmutableLinkedList(newHead);
    }
}
