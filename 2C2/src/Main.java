import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // 1. Ввод размерности матрицы
        System.out.print("Введите размерность матрицы n: ");
        int n = scan.nextInt();

        System.out.print("Введите количество позиций для сдвига k: ");
        int k = scan.nextInt();

        // Оптимизируем k, так как сдвиг на n позиций возвращает матрицу в исходное состояние
        k = k % n;

        int[][] matrix = new int[n][n];

        // 2. Заполнение матрицы случайными числами от -n до n
        // Диапазон: [min, max] -> random.nextInt(max - min + 1) + min
        // Для [-n, n]: random.nextInt(n - (-n) + 1) - n -> random.nextInt(2 * n + 1) - n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        // 3. Выполнение сдвигов
        System.out.println("\nСдвиг вправо на " + k + ":");
        printMatrix(shiftRight(matrix, k));

        System.out.println("\nСдвиг влево на " + k + ":");
        printMatrix(shiftLeft(matrix, k));

        System.out.println("\nСдвиг вверх на " + k + ":");
        printMatrix(shiftUp(matrix, k));

        System.out.println("\nСдвиг вниз на " + k + ":");
        printMatrix(shiftDown(matrix, k));
    }

    // Сдвиг вправо (сдвигаются столбцы)
    public static int[][] shiftRight(int[][] matrix, int k) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][(j + k) % n] = matrix[i][j];
            }
        }
        return result;
    }

    // Сдвиг влево (сдвигаются столбцы)
    public static int[][] shiftLeft(int[][] matrix, int k) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][(j - k + n) % n] = matrix[i][j];
            }
        }
        return result;
    }

    // Сдвиг вверх (сдвигаются строки)
    public static int[][] shiftUp(int[][] matrix, int k) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[(i - k + n) % n][j] = matrix[i][j];
            }
        }
        return result;
    }

    // Сдвиг вниз (сдвигаются строки)
    public static int[][] shiftDown(int[][] matrix, int k) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[(i + k) % n][j] = matrix[i][j];
            }
        }
        return result;
    }

    // Метод для красивого вывода матрицы в консоль
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}
