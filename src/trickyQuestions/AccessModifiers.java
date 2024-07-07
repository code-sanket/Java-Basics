package trickyQuestions;

public class AccessModifiers {

    static class A{

        A(){
            System.out.println("A Class Constructor");
        }
        private String name;  // Only Accessible within class
        public int age; // Accessible everywhere
        protected String gender; // a
    }

    static class B extends A{

    }


    public static void main(String[] args) {
        A aClass = new A();
        aClass.name = "SAnky";
        B bClass = new B();
        bClass.age = 10;
        bClass.gender = "Male";
    }
}
