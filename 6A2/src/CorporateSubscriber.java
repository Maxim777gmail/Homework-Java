package telecom.subscribers;

import telecom.subscribers.MobileSubscriber;
import java.util.ArrayList;
import java.util.List;

public class CorporateSubscriber extends MobileSubscriber {
    private String companyName;
    private String inn;
    private List<String> employeeNumbers = new ArrayList<>();
    private double creditLimit;

    public CorporateSubscriber(String companyName, String inn) {
        this.companyName = companyName;
        this.inn = inn;
    }

    // Специализированный метод: Добавить номер сотрудника в общий пул
    public void addEmployeeNumber(String number) {
        employeeNumbers.add(number);
        System.out.println("Номер " + number + " добавлен в корпоративную сеть компании " + companyName);
    }

    // Специализированный метод: Установить кредитный лимит на компанию
    public void setCreditLimit(double limit) {
        this.creditLimit = limit;
        System.out.println("Для компании установлен кредитный лимит: " + limit + " руб.");
    }

    // Специализированный метод: Выставить единый счет за все номера
    public double calculateTotalCorporateBill() {
        // Упрощенный расчет: фиксированная стоимость за каждый привязанный номер
        double totalCost = employeeNumbers.size() * 300.0;
        System.out.println("Общий корпоративный счет для " + companyName + ": " + totalCost + " руб.");
        return totalCost;
    }
}
