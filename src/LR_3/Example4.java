package LR_3;

public class Example4 {
    public static void main(String[] args) {
        Node node0 = new Node(0,null);
        Node node1 = new Node(0,null);
        Node node2 = new Node(0,null);
        Node node3 = new Node(0,null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;
        while (ref != null){
            System.out.println(" " + ref.value);
            ref = ref.next;
        }

    }
}
