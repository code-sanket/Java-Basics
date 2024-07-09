package threads;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FetchAndSaveData {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Thread producer = new Thread(new Producer(arr , queue));
        Thread consumer = new Thread(new Consumer(queue, hashMap));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Final HashMap: " + hashMap);

    }

    static class Producer implements Runnable {
        private int[] sourceArray;
        private BlockingQueue<Integer> queue;

        public Producer(int[] sourceArray, BlockingQueue<Integer> queue) {
            this.sourceArray = sourceArray;
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int num : sourceArray) {
                    queue.put(num); // Block if queue is full
                    System.out.println("Produced: " + num);
                }
                // Indicate end of data
                queue.put(-1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

   static class Consumer implements Runnable {
        private BlockingQueue<Integer> queue;
        private HashMap<Integer, Integer> hashMap;
        private int index = 0;

        public Consumer(BlockingQueue<Integer> queue, HashMap<Integer, Integer> hashMap) {
            this.queue = queue;
            this.hashMap = hashMap;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int num = queue.take(); // Block if queue is empty
                    if (num == -1) {
                        break;
                    }
                    hashMap.put(index, num);
                    System.out.println("Consumed: " + num);
                    index++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
