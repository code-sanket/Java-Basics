package garbageCollection;

public class GarbageCollectionDemo {
    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++){
            createObject();
        }



        System.gc();
        System.out.println("Garbage Collection Started");
    }

    public static void createObject(){
        MyObject myObject = new MyObject();
    }


}
class MyObject{
    @Override
    protected void finalize() throws Throwable { // finalize  block will be called just before garbage collection
        System.out.println("Garbage Collected");
    }
}
