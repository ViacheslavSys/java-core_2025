package LR_6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example6 {
    public static long sumArray(int[] array) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / numThreads);

        Future<Long>[] futures = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, length);

            futures[i] = executor.submit(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                return localSum;
            });
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }

    // Пример использования
    public static void main(String[] args) throws Exception {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long sum = sumArray(data);
        System.out.println("Сумма: " + sum);
    }
}
