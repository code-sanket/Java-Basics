package threads;

public class OddEven {

   static class PrintNumbers {
        private int number = 1;
        private int maxNumber;

        public PrintNumbers(int maxNumber) {
            this.maxNumber = maxNumber;
        }

        public void printOdd() {
            synchronized (this) {
                while (number <= maxNumber) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        notify(); // Notify waiting thread (even thread) to continue
                    } else {
                        try {
                            wait(); // Wait for even thread to print
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void printEven() {
            synchronized (this) {
                while (number <= maxNumber) {
                    if (number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        notify(); // Notify waiting thread (odd thread) to continue
                    } else {
                        try {
                            wait(); // Wait for odd thread to print
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        PrintNumbers printer = new PrintNumbers(10); // Print numbers up to 10
        Thread oddThread = new Thread(() -> {
            printer.printOdd();
        }, "Odd Thread");

        Thread evenThread = new Thread(() -> {
            printer.printEven();
        }, "Even Thread");

        oddThread.start();
        evenThread.start();
    }

}
