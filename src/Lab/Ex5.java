package Lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex5 {
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
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax) localMax = array[j];
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
}
