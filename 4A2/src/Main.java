public class Main {
    public static void main(String[] args) {
        // 1. Создаем компоненты автомобиля
        Engine v8 = new Engine("V8-Turbo", 450);

        Wheel[] initialWheels = new Wheel[] {
                new Wheel(18, "Летняя"),
                new Wheel(18, "Летняя"),
                new Wheel(18, "Летняя"),
                new Wheel(18, "Летняя")
        };

        // 2. Создаем объект автомобиля (Агрегация/Композиция)
        Car myCar = new Car("Lexus", v8, initialWheels);

        // 3. Демонстрация работы методов
        myCar.printBrand();

        System.out.println("\n--- Проверка целостности шин ---");
        Wheel spareWheel = new Wheel(18, "Летняя (запасное)");
        myCar.changeWheel(2, spareWheel);

        System.out.println("\n--- Заведение двигателя ---");
        myCar.drive();

        System.out.println("\n--- Заправка ---");
        myCar.refuel();
        myCar.drive();

        System.out.println("\n--- Состояние автомобиля ---");
        System.out.println(myCar);
    }
}
