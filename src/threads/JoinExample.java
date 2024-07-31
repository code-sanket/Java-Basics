package threads;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Printing Number using 3 Threads .... ");

        Thread t1 = new Thread(()->{
            for(int i = 0 ; i <= 1000 ; i++){
                System.out.println("Printing Using t1 thread ..." + i);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join(50000);// wait for t1 to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(int i = 1001 ; i <= 3000 ; i++){
                System.out.println("Printing using t2 thread ... " + i);
            }
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join(50000); // wait for t2 to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(int i = 3001 ; i <= 4000 ; i++){
                System.out.println("Printing using t3 ... " + i);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join(); // main thread will wait for t3 thread

        System.out.println("task Completed");
    }
}
