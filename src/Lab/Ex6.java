package Lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex6 {
    public static void main(String[] args) throws Exception {
        int[] array = {3, 5, 2, 9, 11, 4, 8, 7, 25, 1, 14, 6, 33};
        System.out.println("Максимум: " + findMax(array));
    }

    public static int findMax(int[] array) throws Exception {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        Future<Integer>[] futures = new Future[cores];
        int chunkSize = (int) Math.ceil((double) array.length / cores);

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            futures[i] = executor.submit(() -> {
                int localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                return localSum;
            });
        }

        int globalSum = 0;
        for (Future<Integer> future : futures) {
            globalSum = Integer.sum(globalSum, future.get());
        }
        executor.shutdown();
        return globalSum;
    }
}
