package trickyQuestions;

public class MethodOverloading {
    /*
    Method Overloading works on method Signature:
    Method Signature Consist of
    1. No of Arguments
    2. Type of Args
    3. Method Name

    It do not depend on return type.
     */
    public void meth1(){
        System.out.println("Method 1");
    }

    /*
    In Method Overloading access modifier can be diff for diff methods
     */
    private  void meth1(String name){
        System.out.println("Method 2");
    }


}
