import java.util.Arrays;
import java.util.Comparator;

// Класс для работы с массивом объектов Customer
class CustomerArrayManager {
    private Customer[] customers;

    public CustomerArrayManager(Customer[] customers) {
        this.customers = customers;
    }

    // а) Вывод списка покупателей в алфавитном порядке
    public void printAlphabetically() {
        // Создаем копию массива, чтобы не менять исходный порядок
        Customer[] sortedCustomers = Arrays.copyOf(customers, customers.length);

        // Сортируем по фамилии, затем по имени и отчеству
        Arrays.sort(sortedCustomers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int res = c1.getLastName().compareToIgnoreCase(c2.getLastName());
                if (res != 0) return res;
                res = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                if (res != 0) return res;
                return c1.getMiddleName().compareToIgnoreCase(c2.getMiddleName());
            }
        });

        System.out.println("\n--- Список покупателей в алфавитном порядке ---");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }

    // б) Вывод покупателей, у которых номер карты находится в заданном интервале
    public void printByCreditCardRange(long start, long end) {
        System.out.printf("\n--- Покупатели с номером карты в интервале от %d до %d ---\n", start, end);
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() >= start && customer.getCreditCardNumber() <= end) {
                System.out.println(customer);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Покупатели с такими номерами карт не найдены.");
        }
    }
}
