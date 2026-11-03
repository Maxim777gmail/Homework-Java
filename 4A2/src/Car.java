import java.util.Arrays;
import java.util.Objects;

public class Car {
    private String brand;
    private Engine engine;
    private Wheel[] wheels;
    private boolean isFueled;

    public Car(String brand, Engine engine, Wheel[] wheels) {
        if (wheels == null || wheels.length != 4) {
            throw new IllegalArgumentException("У автомобиля должно быть ровно 4 колеса!");
        }
        this.brand = brand;
        this.engine = engine;
        this.wheels = Arrays.copyOf(wheels, wheels.length);
        this.isFueled = false; // По умолчанию машина не заправлена
    }

    // Методы, принадлежащие автомобилю по логике его поведения:

    public void drive() {
        if (isFueled) {
            System.out.println(brand + " готов в путь.");
        } else {
            System.out.println("в " + brand + " отсутсвует бензин, необходима заправка!");
        }
    }

    public void refuel() {
        this.isFueled = true;
        System.out.println(brand + " успешно заправлен.");
    }

    // Индекс колеса от 0 до 3
    public void changeWheel(int wheelIndex, Wheel newWheel) {
        if (wheelIndex < 0 || wheelIndex >= wheels.length) {
            System.out.println("Ошибка: Неверный индекс колеса.");
            return;
        }
        System.out.println("На " + brand + " меняется колесо на позиции " + wheelIndex +
                ". Старое: " + wheels[wheelIndex] + " -> Новое: " + newWheel);
        this.wheels[wheelIndex] = newWheel;
    }

    public void printBrand() {
        System.out.println("Марка автомобиля: " + brand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isFueled == car.isFueled &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(engine, car.engine) &&
                Arrays.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand, engine, isFueled);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    @Override
    public String toString() {
        return "Автомобиль{" +
                "марка='" + brand + '\'' +
                ", " + engine +
                ", колеса=" + Arrays.toString(wheels) +
                ", заправлен=" + isFueled +
                '}';
    }
}
