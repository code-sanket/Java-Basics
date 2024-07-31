package ComparableVSComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    static class Student{
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(2 , "Sanket"));
        studentList.add(new Student(1 , "Ankit"));
        studentList.add(new Student(4, "Archit"));
        studentList.add(new Student(0 , "Vineet"));

        studentList.sort(Comparator.comparingInt(Student::getId));

        for (Student st : studentList){
            System.out.println(st.getId() + " " + st.getName());
        }
    }



}
