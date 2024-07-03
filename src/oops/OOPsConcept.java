package oops;


public class OOPsConcept {

     static class Base{
        void print(){
            System.out.println("Printing Base Class");
        }
    }

     static class Child extends Base{
        @Override
        void print() {
            System.out.println("Printing Child Class");
        }
    }

     static void print (Base base){
        base.print();
    }

    public static void main(String[] args) {
         Base b = new Base();
         b.print();
         Base a = new Child(); // what ever is the
         a.print();
         print(b);
    }
}
