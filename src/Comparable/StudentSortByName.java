package Comparable;

import java.util.Comparator;

public class StudentSortByName implements Comparator<Student>{
    String name;
    int age;
    public StudentSortByName(String name, int age){
        this.name = name;
        this.age = age;
    }



    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
