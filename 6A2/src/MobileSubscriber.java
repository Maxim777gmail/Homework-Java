package telecom.subscribers;

import telecom.interfaces.InfoService;
import telecom.interfaces.ServiceManagement;
import telecom.interfaces.AccountManagement;
import telecom.models.Tariff;
import telecom.models.PaymentInfo;
import telecom.models.Contract;
import java.util.ArrayList;
import java.util.List;

public class MobileSubscriber implements AccountManagement, InfoService, ServiceManagement {
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected double balance;
    protected int trafficMb;
    protected Tariff currentTariff;
    protected Contract contract;
    protected List<PaymentInfo> payments = new ArrayList<>();
    protected boolean isActive = false;

    @Override
    public Contract signContract(String clientData) {
        this.contract = new Contract("CTR-" + System.currentTimeMillis(), clientData);
        System.out.println("Договор оформлен для: " + clientData);
        return this.contract;
    }

    @Override
    public void openAccountAndNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.trafficMb = 5120; // 5 ГБ по умолчанию
        this.isActive = true;
        System.out.println("Открыт счет для номера: " + phoneNumber);
    }

    @Override
    public void editProfile(String name, String email) {
        this.name = name;
        this.email = email;
        System.out.println("Профиль обновлен: " + name + " (" + email + ")");
    }

    @Override
    public void closeAccountAndNumber() {
        this.isActive = false;
        System.out.println("Счет и номер " + this.phoneNumber + " успешно закрыты.");
    }

    @Override
    public String getNumberDetails() {
        return String.format("Абонент: %s, Номер: %s, Тариф: %s",
                name, phoneNumber, currentTariff != null ? currentTariff.name : "Не выбран");
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public int checkRemainingTraffic() {
        return this.trafficMb;
    }

    @Override
    public List<PaymentInfo> getPaymentHistory() {
        return this.payments;
    }

    @Override
    public void changeTariff(Tariff newTariff) {
        this.currentTariff = newTariff;
        System.out.println("Тариф изменен на: " + newTariff.name);
    }

    @Override
    public void changeOperator(String newOperatorName) {
        System.out.println("Инициирован переход к оператору " + newOperatorName + " с сохранением номера " + this.phoneNumber);
    }

    @Override
    public void topUpBalance(double amount) {
        this.balance += amount;
        this.payments.add(new PaymentInfo(amount, "Пополнение баланса"));
        System.out.println("Баланс пополнен на " + amount + " руб. Текущий баланс: " + this.balance);
    }
}
