import java.util.ArrayList;
import java.util.List;

public class Payment {
    // Список для хранения товаров в текущей покупке
    private final List<Item> items = new ArrayList<>();
    private double totalAmount = 0.0;

    // Внутренний класс (Inner class), описывающий товар
    public class Item {
        private final String name;
        private final double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
            // При создании товара он автоматически добавляется в список покупки
            Payment.this.items.add(this);
            Payment.this.totalAmount += price;
        }

        @Override
        public String toString() {
            return name + " (Цена: " + price + " руб.)";
        }
    }

    // Метод для вывода информации о покупке
    public void printReceipt() {
        System.out.println("--- Чек покупки ---");
        for (Item item : items) {
            System.out.println("- " + item);
        }
        System.out.printf("Итого к оплате: %.2f руб.%n", totalAmount);
    }

    // Демонстрация работы программы
    public static void main(String[] args) {
        // 1. Создаем объект платежа (покупку)
        Payment payment = new Payment();

        // 2. Формируем покупку, создавая объекты внутреннего класса
        // Синтаксис: имяОбъектаВнешнегоКласса.new ВнутреннийКласс(...)
        payment.new Item("Ноутбук", 40000.0);
        payment.new Item("Мышь беспроводная", 1500.50);
        payment.new Item("Коврик для мыши", 540.0);

        // 3. Выводим результат
        payment.printReceipt();
    }
}
