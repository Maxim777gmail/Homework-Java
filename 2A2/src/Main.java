import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество чисел (n): ");
        if (!scan.hasNextInt()) return;
        int n = scan.nextInt();

        String[] numbers = new String[n];
        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.next();
        }

        // Сортировка по возрастанию длины
        Arrays.sort(numbers, Comparator.comparingInt(String::length));

        System.out.println("\nВ порядке возрастания длины:");
        for (String num : numbers) {
            System.out.println(num + " (длина: " + num.length() + ")");
        }

        // Сортировка по убыванию длины
        Arrays.sort(numbers, Comparator.comparingInt(String::length).reversed());

        System.out.println("\nВ порядке убывания длины:");
        for (String num : numbers) {
            System.out.println(num + " (длина: " + num.length() + ")");
        }

        scan.close();
    }
}
