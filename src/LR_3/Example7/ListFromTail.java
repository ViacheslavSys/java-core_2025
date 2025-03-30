package LR_3.Example7;

import LR_3.Node;

public class ListFromTail {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i <= 9; i++) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}
