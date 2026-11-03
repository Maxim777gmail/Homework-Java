import java.util.Arrays;
import java.util.List;

// Демонстрация работы класса
public class Main {
    public static void main(String[] args) {
        // 1. Создаем список (динамический массив) размерности N из комплексных координат
        List<Complex> complexCoordinates = Arrays.asList(
                new Complex(1.0, 2.0),  // 1 + 2i
                new Complex(3.0, -1.0), // 3 - i
                new Complex(0.0, 4.0),  // 0 + 4i
                new Complex(2.0, 5.0)   // 2 + 5i
        );

        System.out.println("Исходные комплексные координаты:");
        System.out.println("--------------------------------");

        // 2. Передаем список в метод для сложения всех элементов
        Complex totalSum = Complex.sumArray(complexCoordinates);
        System.out.println("Результат сложения всех элементов: " + totalSum);

        // 3. Передаем список в метод для умножения всех элементов
        Complex totalProduct = Complex.multiplyArray(complexCoordinates);
        System.out.println("Результат умножения всех элементов: " + totalProduct);

        // 4. Демонстрация отдельной операции (например, деления)
        Complex c1 = new Complex(4, 2);
        Complex c2 = new Complex(3, -1);
        System.out.println("\nПример деления (" + c1 + ") / (" + c2 + ") = " + c1.divide(c2));
    }
}
