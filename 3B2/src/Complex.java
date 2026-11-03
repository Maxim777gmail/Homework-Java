import java.util.List;

// Класс, представляющий комплексное число
class Complex {
    private final double real; // Действительная часть
    private final double imag; // Мнимая часть

    // Конструктор
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() { return real; }
    public double getImag() { return imag; }

    // Сложение: (a + bi) + (c + di) = (a + c) + (b + d)i
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    // Вычитание: (a + bi) - (c + di) = (a - c) + (b - d)i
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    // Умножение: (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
    public Complex multiply(Complex other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new Complex(r, i);
    }

    // Деление: (a + bi) / (c + di) = [(ac + bd) / (c² + d²)] + [(bc - ad) / (c² + d²)]i
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль (абсолютное значение делителя равно 0).");
        }
        double r = (this.real * other.real + this.imag * other.imag) / denominator;
        double i = (this.imag * other.real - this.real * other.imag) / denominator;
        return new Complex(r, i);
    }

    // Метод для суммирования списка комплексных чисел
    public static Complex sumArray(List<Complex> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new Complex(0, 0);
        }
        Complex result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = result.add(numbers.get(i));
        }
        return result;
    }

    // Метод для перемножения списка комплексных чисел
    public static Complex multiplyArray(List<Complex> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new Complex(0, 0); // Или new Complex(1, 0) в зависимости от логики пустых данных
        }
        Complex result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = result.multiply(numbers.get(i));
        }
        return result;
    }

    // Красивый вывод комплексного числа
    @Override
    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + Math.abs(imag) + "i";
        }
    }
}