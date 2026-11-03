import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String encrypt(String text) {
        int length = text.length();
        int n = (int) Math.sqrt(length);

        if (n * n != length) {
            throw new IllegalArgumentException("Длина текста должна быть полным квадратом (1, 4, 9, 16, 25...).");
        }

        //Запись текста в квадратную таблицу n x n
        char[][] matrix = new char[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = text.charAt(index++);
            }
        }

        //Поворот на 90 градусов по часовой стрелке
        char[][] rotated = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        //Обмен строк (1-я с последней, 2-я с предпоследней и т.д.)
        for (int i = 0; i < n / 2; i++) {
            char[] temp = rotated[i];
            rotated[i] = rotated[n - 1 - i];
            rotated[n - 1 - i] = temp;
        }

        //Обмен столбцов (1-й со 2-м, 3-й с 4-м и т.д.)
        for (int j = 0; j < n - 1; j += 2) {
            for (int i = 0; i < n; i++) {
                char temp = rotated[i][j];
                rotated[i][j] = rotated[i][j + 1];
                rotated[i][j + 1] = temp;
            }
        }

        //Обход по спирали по часовой стрелке из левого верхнего угла
        StringBuilder result = new StringBuilder();
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Движение влево -> вправо по верхней строке
            for (int j = left; j <= right; j++) {
                result.append(rotated[top][j]);
            }
            top++;

            // Движение вниз по правому столбцу
            for (int i = top; i <= bottom; i++) {
                result.append(rotated[i][right]);
            }
            right--;

            // Движение вправо -> влево по нижней строке
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.append(rotated[bottom][j]);
                }
                bottom--;
            }

            // Движение вверх по левому столбцу
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.append(rotated[i][left]);
                }
                left++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Пример для n = 3 (длина 9)
        String sampleText3x3 = "123456789";
        System.out.println("Исходный текст (3x3): " + sampleText3x3);
        System.out.println("Зашифрованный:       " + encrypt(sampleText3x3));

        // Пример для n = 4 (длина 16)
        String sampleText4x4 = "ABCDEFGHIJKLMNOP";
        System.out.println("\nИсходный текст (4x4): " + sampleText4x4);
        System.out.println("Зашифрованный:       " + encrypt(sampleText4x4));
    }
}
