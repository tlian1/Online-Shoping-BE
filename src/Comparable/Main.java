package Comparable;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Student[] arrNames = {
                new Student("Mike", 34),
                new Student("Denis", 25),
                new Student("Denis", 20),
                new Student("Tommy", 15),
                new Student("Tommy", 23),
                new Student("Tommy", 13)


        };

//        Arrays.sort(arrNames);
//
//        System.out.println("by Comparable ");
//        for (Student arrName : arrNames){
//            System.out.println(arrName.age);
//        }
//
//        Arrays.sort(arrNames, new StudentSortByName());
//
//        System.out.println("by Comparator - compare()");
//        for (Student arrName : arrNames) {
//            System.out.println(arrName.name);
//        }
//
//
//        Arrays.sort(arrNames, Comparator.comparing(s -> s.name));
//        System.out.println("by Comparator - comparing()");
//        for (Student arrName : arrNames) {
//            System.out.println(arrName.name);
//        }



//        Arrays.sort(arrNames, Comparator.comparing((Student student) -> student.age)
//                .thenComparing(student -> student.name)
//        );
//
//        System.out.println("by Comparator - comparing() with 2 param");
//        for (Student arrName : arrNames) {
//            System.out.println(arrName.age + " - " + arrName.name);
//        }
    }
}
