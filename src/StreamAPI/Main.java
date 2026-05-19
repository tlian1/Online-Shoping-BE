package StreamAPI;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        System.out.println("ForEach");
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                if (number == 2) {
                    int numNew = number * number;
                }
            }
        }

        System.out.println("StreamAPI");
        Integer result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        System.out.println("StreamAPI");
        boolean result2 = numbers.stream()
                .anyMatch(n -> n > 8);

        System.out.println(result2);

    }
}
