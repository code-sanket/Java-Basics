package threads;

import java.util.List;

class PrintOddEvenUsingThreads {

    int currCounter = 0;
    List<Integer> oddEvenList;

     PrintOddEvenUsingThreads(List<Integer> oddEvenList){
        this.oddEvenList = oddEvenList;
    }
        void printOdd(){
            synchronized (this){
                while(currCounter < oddEvenList.size()){
                    int ele = oddEvenList.get(currCounter);
                    if(ele % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + " : " + ele);
                        currCounter++;
                        notify();
                    }else{
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

        void printEven(){
            synchronized (this){
                while (currCounter < oddEvenList.size()){
                    int ele = oddEvenList.get(currCounter);
                    if (ele % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " : " + ele);
                        currCounter++;
                        notify();
                    }else{
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }


     public static void main(String[] args) {
        List<Integer> oddEven = List.of(1,2,4,5,6,3,7,11,46);
         PrintOddEvenUsingThreads printOddEvenUsingThreads = new PrintOddEvenUsingThreads(oddEven);
         Thread oddThread = new Thread(()->{
             printOddEvenUsingThreads.printOdd();
         } , "oddThread");

         Thread evenThread = new Thread(()->{
             printOddEvenUsingThreads.printEven();
         } , "evenThread");

         oddThread.start();
         evenThread.start();
     }
}
