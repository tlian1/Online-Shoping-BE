package Exception_Handlers;

import org.xml.sax.ErrorHandler;

import java.io.IOException;

public class MainException {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
        example8();
        example9();
        example10();
    }
        public static void example1(){
            System.out.println("1. ArithmeticException");

            try{
                int x = 10 / 0;
                System.out.println(x);
            }catch (ArithmeticException e) {
                System.out.println("Ошибка: деления на ноль");
            }
            System.out.println();
        }

        public static void example2(){
            System.out.println("2. NullPointerException");

            try{
                String text = null;
                System.out.println(text.length());
            }catch (NullPointerException e){
                System.out.println("Ошибка: строка пустая (null)");
            }
            System.out.println();
        }

        public static void example3(){
            System.out.println("3. ArrayIndexOutOfBoundsException");

            try{
                int[] arr = {1, 2, 3};
                System.out.println(arr[5]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Ошибка: такого индекса нет");
            }
            System.out.println();
        }

        public static void example4(){
            System.out.println("4. NumberFormatException");

            try{
                int num = Integer.parseInt("abc");
                System.out.println(num);
            }catch (NumberFormatException e){
                System.out.println("Ошибка: строка не может быть числом");
            }
            System.out.println();
        }

        public static void example5(){
            System.out.println("5. finally");
            try{
                System.out.println("код в try");
            }catch (Exception e){
                System.out.println("Код в catch");
            }finally {
                System.out.println("Блок finally выполнился");
            }
            System.out.println();
        }

        public static void example6(){
            System.out.println("6. throw");
            try{
                chekAge(15);
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
            System.out.println();
        }

        public static void chekAge(int age){
            if (age < 18){
                throw new IllegalArgumentException("Доступ запрещен");
            }
            System.out.println("Доступ разрешен");
        }

        public static void example7(){
            System.out.println("7. throws");

            try{
                readFile();
            }catch (IOException e){
                System.out.println("Ошибка в файлах: " + e.getMessage());
            }
            System.out.println();

        }
        public static void readFile() throws IOException, NullPointerException{
            throw new IOException("Файл не найден");
        }

        public static void example8(){
            System.out.println("8. Несколько catch");

            try{
                String s = null;
                System.out.println(s.length());
                int x = 10 / 0;
            }catch (NullPointerException e) {
                System.out.println(" Поймали NullPointerexception");
            }catch (ArithmeticException e){
                System.out.println("Поймали ArithmeticException");
            }
            System.out.println();
        }

        public static void example9(){
            System.out.println("9. Custom Exception");

            try{
                chekName("");
            }catch (MyException e){
                System.out.println("Своя ошибка: " + e.getMessage());
            }
            System.out.println();
        }

        public static void chekName(String name) throws MyException {
            if (name == null || name.isEmpty()){
                throw new MyException("Имя пустое");
            }
            System.out.println("Имя: " + name);
        }

        static class MyException extends Exception {
            public MyException(String message){
                super(message);
            }
        }


        public static void example10(){
            System.out.println("10. Общий handler");

            try{
                int[] nums = {1, 2, 3};
                System.out.println(nums[10]);
            }catch (Exception e) {
                ErrorHandler.handle(e);
            }
            System.out.println();
        }

        static class ErrorHandler {
            public static void handle(Exception e){
                System.out.println("Тип ошибки: " + e.getClass().getSimpleName());
                System.out.println("Сообщение: " + e.getMessage());
            }
        }




}
