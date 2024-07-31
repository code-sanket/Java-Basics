package trickyQuestions;

public class Constructors {

    public static void main(String[] args) {
        A obj = new A("Non-Private");
    }

}

class A{
     private A() {
        System.out.println("Print Constructor"); // this will not be accessible outside the class
    }

    A(String type){
        System.out.println("Printing " + type);
    }
}