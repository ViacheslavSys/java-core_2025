package LR_3;

import java.util.*;

public class CollectionPerformanceTest {
    private static int ELEMENT_COUNT = 17000000;

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        fillCollections(arrayList, arrayDeque, treeMap);

        // 1. Добавление в начало
        System.out.println("1. Добавление в начало:");
        System.out.println("ArrayDeque: " + measureAddFirst(arrayDeque) + " нс");
        System.out.println("TreeMap: " + measureAddFirst(treeMap) + " нс");
        System.out.println("ArrayList: " + measureAddFirst(arrayList) + " нс\n");

        // 2. Добавление в конец
        System.out.println("2. Добавление в конец:");
        System.out.println("ArrayDeque: " + measureAddLast(arrayDeque) + " нс");
        System.out.println("TreeMap: " + measureAddLast(treeMap) + " нс\n");
        System.out.println("ArrayList: " + measureAddLast(arrayList) + " нс\n");

        // 3. Добавление в середину
        System.out.println("3. Добавление в середину:");
        System.out.println("ArrayDeque: " + measureAddMiddle(arrayDeque) + " нс");
        System.out.println("TreeMap не поддерживает");
        System.out.println("ArrayList: " + measureAddMiddle(arrayList) + " нс\n");

        // 4. Удаление из начала
        System.out.println("4. Удаление из начала:");
        System.out.println("ArrayDeque: " + measureRemoveFirst(arrayDeque) + " нс");
        System.out.println("TreeMap: " + measureRemoveFirst(treeMap) + " нс");
        System.out.println("ArrayList: " + measureRemoveFirst(arrayList) + " нс\n");

        // 5. Удаление из конца
        System.out.println("5. Удаление из конца:");
        System.out.println("ArrayDeque: " + measureRemoveLast(arrayDeque) + " нс");
        System.out.println("TreeMap: " + measureRemoveLast(treeMap) + " нс");
        System.out.println("ArrayList: " + measureRemoveLast(arrayList) + " нс\n");

        // 6. Удаление из середины
        System.out.println("6. Удаление из середины:");
        System.out.println("ArrayDeque: " + measureRemoveMiddle(arrayDeque) + " нс");
        System.out.println("TreeMap: " + measureRemoveMiddle(treeMap) + " нс");
        System.out.println("ArrayList: " + measureRemoveMiddle(arrayList) + " нс\n");

        // 7. Получение элемента по индексу/ключу
        System.out.println("7. Получение элемента:");
        System.out.println("ArrayDeque не поддерживает");
        System.out.println("TreeMap не поддерживает");
        System.out.println("ArrayList: " + measureGet(arrayList) + " нс");
    }

    private static void fillCollections(List<Integer> list, Deque<Integer> deque, TreeMap<Integer, Integer> map) {
        for (int i = 1; i <= ELEMENT_COUNT; i++) {
            list.add(i);
            deque.add(i);
            map.put(i, i);
        }

    }
    private static long measureAddFirst(ArrayDeque<Integer> deque) {
        long start = System.nanoTime();
        deque.addFirst(-1);

        return System.nanoTime() - start;
    }

    private static long measureAddFirst(TreeMap<Integer, Integer> map) {
        long start = System.nanoTime();
        map.put(0, -1);

        return System.nanoTime() - start;
    }

    private static long measureAddFirst(ArrayList<Integer> list) {
        long start = System.nanoTime();
        list.add(0, -1);

        return System.nanoTime() - start;
    }

    private static long measureAddLast(ArrayDeque<Integer> deque) {
        long start = System.nanoTime();
        deque.addLast(-1);

        return System.nanoTime() - start;
    }
    
    private static long measureAddLast(TreeMap<Integer, Integer> list) {
        long start = System.nanoTime();

        list.put(ELEMENT_COUNT+1,-1);

        return System.nanoTime() - start;
    }

    private static long measureAddLast(ArrayList<Integer> list) {
        long start = System.nanoTime();
        list.add(-1);

        return System.nanoTime() - start;
    }

    private static long measureAddMiddle(ArrayDeque<Integer> deque) {

        long start = System.nanoTime();

        int half = deque.size() / 2;

        Integer[] buffer = new Integer[half];
        for (int i = 0; i < half; i++) {
            buffer[i] = deque.removeFirst();
        }

        deque.addFirst(half);

        for (int i = buffer.length - 1; i >= 0; i--) {
            deque.addFirst(buffer[i]);
        }

        return System.nanoTime() - start;
    }

    private static long measureAddMiddle(ArrayList<Integer> list) {
        long startTime = System.nanoTime();

        int middleIndex = list.size() / 2;
        list.add(middleIndex, -1);

        return System.nanoTime() - startTime;
    }

    private static long measureRemoveFirst(ArrayDeque<Integer> deque) {
        long start = System.nanoTime();
        deque.removeFirst();

        return System.nanoTime() - start;
    }

    private static long measureRemoveFirst(TreeMap<Integer, Integer> map) {
        long start = System.nanoTime();

            map.pollFirstEntry();

        return System.nanoTime() - start;
    }

    private static long measureRemoveFirst(ArrayList<Integer> list) {
        long start = System.nanoTime();

            list.remove(0);

        return System.nanoTime() - start;
    }

    private static long measureRemoveLast(ArrayDeque<Integer> deque) {
        long start = System.nanoTime();
        deque.removeLast();

        return System.nanoTime() - start;
    }

    private static long measureRemoveLast(TreeMap<Integer, Integer> map) {
        long start = System.nanoTime();
        map.pollLastEntry();

        return System.nanoTime() - start;
    }

    private static long measureRemoveLast(ArrayList<Integer> list) {
        long start = System.nanoTime();
        list.remove(list.size() - 1);

        return System.nanoTime() - start;
    }

    // Для ArrayDeque - не поддерживает прямое удаление из середины
    private static long measureRemoveMiddle(ArrayDeque<Integer> deque) {
       long start = System.nanoTime();

        int halfSize = deque.size() / 2;
        Object[] temp = new Object[halfSize];

        for (int i = 0; i < halfSize; i++) {
            temp[i] = deque.removeFirst();
        }

        deque.removeFirst();

        for (int i = temp.length - 1; i >= 0; i--) {
            deque.addFirst((Integer)temp[i]);
        }

        return System.nanoTime() - start;
    }


    private static long measureRemoveMiddle(TreeMap<Integer, Integer> map) {
        long start = System.nanoTime();

        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Integer middleKey = keys[keys.length / 2];
        map.remove(middleKey);

        return System.nanoTime() - start;
    }

    private static long measureRemoveMiddle(ArrayList<Integer> list) {
        long start = System.nanoTime();
        list.remove(list.size() / 2);
        return System.nanoTime() - start;
    }




    private static long measureGet(ArrayList<Integer> list) {
        long start = System.nanoTime();

        Integer element = list.get(list.size() - 5);
        return System.nanoTime() - start;
    }

}
