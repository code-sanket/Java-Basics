package trickyQuestions;

public class TrickyQuestions {
    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[10];

        b = a; // this valid statement because compiler only checks the type of the array

        b[99] = 21;
        /*
        Try with Finally Block is also a valid exception
         */
        try {
            System.out.println("Inside Try Block");
        }finally {
            System.out.println("Inside Finally Block");
        }




    }
}
