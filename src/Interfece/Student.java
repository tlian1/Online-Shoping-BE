package Interfece;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public  String toString() {
        return "Interfece.Student{" +
                "name='" + name + "\'" +
                ", age=" + age +
                '}';
    }
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }



}

