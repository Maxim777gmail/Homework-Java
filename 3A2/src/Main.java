import java.util.Arrays;
import java.util.Comparator;

// Главный класс программы
public class Main {
    public static void main(String[] args) {
        // Создаем массив объектов Customer, используя разные конструкторы
        Customer[] customersList = new Customer[] {
                new Customer(1, "Иванов", "Иван", "Иванович", "ул. Ленина 5", 4444555566667777L, "BY49ALFA30121111111111111111"),
                new Customer(2, "Петров", "Петр", "Петрович", "ул. Пушкина 12", 1111222233334444L, "BY49ALFA30122222222222222222"),
                new Customer(3, "Алексеев", "Алексей", "Алексеевич", "ул. Чехова 8", 5555666677778888L, "BY49ALFA30123333333333333333"),
                new Customer(4, "Иванов", "Сергей", "Петрович", "ул. Садовая 1", 2222333344445555L, "BY49ALFA30124444444444444444")
        };

        // Инициализируем менеджер массива
        CustomerArrayManager manager = new CustomerArrayManager(customersList);

        // Демонстрация критерия А: Алфавитный порядок
        manager.printAlphabetically();

        // Демонстрация критерия Б: Интервал номеров кредитных карт
        long rangeStart = 2000000000000000L;
        long rangeEnd = 5000000000000000L;
        manager.printByCreditCardRange(rangeStart, rangeEnd);
    }
}
