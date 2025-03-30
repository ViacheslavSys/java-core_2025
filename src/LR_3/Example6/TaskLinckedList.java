package LR_3.Example6;

import java.util.LinkedList;
import java.util.ListIterator;

public class TaskLinckedList {
    public static void main(String[] args) {
        int N = 100000;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();

        while (list.size() > 1) {
            list.addLast(list.removeFirst());
            list.removeFirst();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Последний оставшийся (LinkedList): " + list.get(0));
        System.out.println("Время выполнения (LinkedList): " + (endTime - startTime) + " мс");
    }
}
