package LR_3;

import java.util.NoSuchElementException;

public class Example8 {
    private Node head;
    private Node tail;
    private int size;

    public Example8() {
        head = null;
        tail = null;
        size = 0;
    }


    public void createHead(int[] values) {
        clear();
        for (int i = values.length - 1; i >= 0; i--) {
            addFirst(values[i]);
        }
    }


    public void createTail(int[] values) {
        clear();
        for (int value : values) {
            addLast(value);
        }
    }


    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }


    public void addLast(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value, current.next);
            current.next = newNode;
            size++;
        }
    }


    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }


    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (size == 1) {
            clear();
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }


    public void createHeadRec(int[] values) {
        clear();
        if (values.length > 0) {
            createHeadRecHelper(values, values.length - 1);
        }
    }

    private void createHeadRecHelper(int[] values, int index) {
        if (index < 0) return;
        addFirst(values[index]);
        createHeadRecHelper(values, index - 1);
    }


    public void createTailRec(int[] values) {
        clear();
        if (values.length > 0) {
            createTailRecHelper(values, 0);
        }
    }

    private void createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return;
        addLast(values[index]);
        createTailRecHelper(values, index + 1);
    }


    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecHelper(node.next);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Example8 list = new Example8();

        System.out.println("=== Итеративные методы ===");
        list.createHead(new int[]{3, 2, 1});
        System.out.println("createHead: " + list);

        list.clear();
        list.createTail(new int[]{1, 2, 3});
        System.out.println("createTail: " + list);

        list.addFirst(0);
        System.out.println("addFirst: " + list);

        list.addLast(4);
        System.out.println("addLast: " + list);

        list.insert(2, 99);
        System.out.println("insert: " + list);

        list.removeFirst();
        System.out.println("removeFirst: " + list);

        list.removeLast();
        System.out.println("removeLast: " + list);

        list.remove(1);
        System.out.println("remove: " + list);

        // Тестирование рекурсивных методов
        System.out.println("\n=== Рекурсивные методы ===");
        list.createHeadRec(new int[]{5, 4, 3});
        System.out.println("createHeadRec: " + list.toStringRec());

        list.clear();
        list.createTailRec(new int[]{1, 2, 3});
        System.out.println("createTailRec: " + list.toStringRec());
    }
}