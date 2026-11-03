import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем массив объектов класса Прямая
        List<Line> lines = new ArrayList<>();

        lines.add(new Line(new Rational(1), new Rational(2), new Rational(3)));  // x + 2y + 3 = 0
        lines.add(new Line(new Rational(2), new Rational(4), new Rational(-5))); // 2x + 4y - 5 = 0 (Параллельна 1-й)
        lines.add(new Line(new Rational(3), new Rational(1), new Rational(1)));  // 3x + y + 1 = 0
        lines.add(new Line(new Rational(6), new Rational(2), new Rational(7)));  // 6x + 2y + 7 = 0 (Параллельна 3-й)
        lines.add(new Line(new Rational(0), new Rational(1), new Rational(-2))); // 0x + y - 2 = 0  (Горизонтальная)
        lines.add(new Line(new Rational(0), new Rational(3), new Rational(9)));  // 0x + 3y + 9 = 0 (Параллельна 5-й)

        System.out.println("=== 1. Анализ прямых и пересечения с осями ===");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("Прямая L" + (i + 1) + ": " + lines.get(i));
            System.out.println("   " + lines.get(i).getAxisIntersections());
        }

        System.out.println("\n=== 2. Пересечение двух прямых ===");
        System.out.println("L1 и L2: " + lines.get(0).intersect(lines.get(1)));
        System.out.println("L1 и L3: " + lines.get(0).intersect(lines.get(2)));
    }
}
