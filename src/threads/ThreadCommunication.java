package threads;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8,1,2};
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);
        HashMap<Integer , Integer> map = new HashMap<>();


        Thread fetchThread = new Thread(new FetchData(arr , blockingQueue));
        Thread saveThread = new Thread(new SaveData(blockingQueue , map , 1));

        fetchThread.start();
        saveThread.start();

        fetchThread.join();
        saveThread.join();

    }

    static class FetchData implements Runnable{
        private int[] sourceArray;
        BlockingQueue<Integer> blockingQueue;

        FetchData(int[] sourceArray , BlockingQueue<Integer> blockingQueue){
            this.sourceArray = sourceArray;
            this.blockingQueue = blockingQueue;
        }


        @Override
        public void run() {
            for(int i : sourceArray){
                try {
                    blockingQueue.put(i);
                    System.out.println("Data Fetched " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                blockingQueue.put(-1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class SaveData implements Runnable{

        BlockingQueue<Integer> blockingQueue;
        HashMap<Integer , Integer> map;
        int index;

        public SaveData(BlockingQueue<Integer> blockingQueue, HashMap<Integer, Integer> map, int index) {
            this.blockingQueue = blockingQueue;
            this.map = map;
            this.index = index;
        }

        @Override
        public void run() {
            while (true){
                int ele = 0;
                try {
                    ele = blockingQueue.take();
                    if (ele == -1){
                        System.out.println("End of Data");
                        break;
                    }else{
                        map.put(index , ele);
                        System.out.println("Data Saved " + ele);
                        index++;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


}
