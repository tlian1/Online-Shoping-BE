package Comparable;

public class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Student o) {
        Student other = (Student) o;
        return Integer.compare(this.age, o.age);

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
