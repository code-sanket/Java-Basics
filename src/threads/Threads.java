package threads;

public class Threads {

    static class Thread1 extends Thread{

        @Override
        public void run() {
            for(int i = 0 ; i < 1000 ; i++){
                System.out.println("Thread1 is Counting " + i);
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            for(int i = 0 ; i < 1000 ; i++){
                System.out.println("Thread2 is Counting " + i);
            }
        }
    }

    /*
    There are two ways of creating a thread
    1. To create a thread class and override the run method
    then we will call thread.start();
    2. Another one is to Implement the runnable interface then provide this implementation to a thread
    then call start() method.

    Now if you simply create a runnable interface and give impl using lambda and then try to run
    that particular runnable impl using run  method it will run sequentially and call the run method of
    current thread.

    Also if you want to sleep a thread then you should call thread.sleep() inside the run method of
    that particular thread sleep method works on the current thread not on the which it is called.
     */

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();

        Runnable t3 = ()-> {
            for (int i = 0 ; i < 1000 ; i++){
                System.out.println("Thread is running using lambda EXP .i.e " + i);
            }
        };

        System.out.println(Thread.currentThread().getPriority()); //main thread


        Thread testingThread = new Thread(t3);
        Thread testingThreadWithLambda = new Thread(()->{
            System.out.println("I am thread with lambda experission for providing the implementation of runnable interface");
        });
        testingThreadWithLambda.setPriority(10);
        testingThreadWithLambda.start();
        testingThread.setName("My Thread");
        testingThread.setPriority(6);
        testingThread.start();
        t1.start();

    }
}
