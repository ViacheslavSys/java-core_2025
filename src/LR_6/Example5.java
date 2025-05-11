package LR_6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example5 {
    public static int findMax(int[] array) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / numThreads);

        Future<Integer>[] futures = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, length);

            futures[i] = executor.submit(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    localMax = Math.max(localMax, array[j]);
                }
                return localMax;
            });
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            globalMax = Math.max(globalMax, future.get());
        }

        executor.shutdown();
        return globalMax;
    }

    // Пример использования
    public static void main(String[] args) throws Exception {
        int[] data = {3, 15, 8, 23, 4, 42, 16, 7, 90, 1};
        int max = findMax(data);
        System.out.println("Максимум: " + max);
    }
}
