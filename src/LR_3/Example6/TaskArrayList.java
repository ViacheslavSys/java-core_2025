package LR_3.Example6;

import java.util.ArrayList;

public class TaskArrayList {
    public static void main(String[] args) {
        int N = 100000;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();

        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Последний оставшийся: " + list.get(0));
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
