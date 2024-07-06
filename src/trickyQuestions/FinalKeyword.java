package trickyQuestions;

public class FinalKeyword {

    /*
    - Final Method can be overloaded
     */
    static class A{
        final void method1(){
            System.out.println("final Method");
        }

        /*
        Overloaded final method
         */
        void method1(String name){
            System.out.println("Overloaded Final Method");
        }
    }

    /*
    Overloaded Final Method can be overriden in sub-class
     */
    static class B extends A{
        @Override
        void method1(String name) {
            System.out.println("Overriding the overloaded final method");
        }
    }

    public static void main(String[] args) {
        A classA = new A();
        classA.method1();
        classA.method1("Sanket");

        B classB = new B();
        classB.method1("Anshul");
    }




}
