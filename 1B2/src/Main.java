import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество чисел (N): ");
        if (!scan.hasNextInt()) {
            System.out.println("Ошибка: требуется ввести целое число.");
            return;
        }
        int n = scan.nextInt();

        if (n <= 0) {
            System.out.println("N должно быть больше нуля.");
            return;
        }

        System.out.println("Введите " + n + " целых чисел:");

        // Считываем первое число для инициализации минимума и максимума
        int firstNum = scan.nextInt();
        int max = firstNum;
        int min = firstNum;

        // Считываем остальные N - 1 чисел
        for (int i = 1; i < n; i++) {
            int currentNum = scan.nextInt();
            if (currentNum > max) {
                max = currentNum;
            }
            if (currentNum < min) {
                min = currentNum;
            }
        }

        System.out.println("Наибольшее число: " + max);
        System.out.println("Наименьшее число: " + min);

        scan.close();
    }
}