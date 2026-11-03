import telecom.models.Tariff;
import telecom.subscribers.CorporateSubscriber;
import telecom.subscribers.InternetSubscriber;
import telecom.subscribers.MobileSubscriber;

public class Main {
    public static void main(String[] args) {
        Tariff ultraTariff = new Tariff("Ультра 2026", 500.0);

        System.out.println("--- 1. РАБОТА С ОБЫЧНЫМ АБОНЕНТОМ ---");
        MobileSubscriber citizen = new MobileSubscriber();
        citizen.signContract("Иванов Иван Иванович, Паспорт: 45** ******");
        citizen.openAccountAndNumber("+79991112233");
        citizen.editProfile("Иван Иванов", "ivan@email.com");
        citizen.changeTariff(ultraTariff);
        citizen.topUpBalance(1000.0);
        System.out.println("Баланс: " + citizen.checkBalance());

        System.out.println("\n--- 2. РАБОТА С ИНТЕРНЕТ-АБОНЕНТОМ ---");
        InternetSubscriber internetUser = new InternetSubscriber();
        internetUser.openAccountAndNumber("ЛС-8883321"); // Вместо номера — лицевой счет
        internetUser.allocateStaticIp("192.168.1.100");
        internetUser.activateTurboButton(100);

        System.out.println("\n--- 3. РАБОТА С КОРПОРАТИВНЫМ АБОНЕНТОМ ---");
        CorporateSubscriber corp = new CorporateSubscriber("ООО Рога и Копыта", "7701020304");
        corp.signContract("Юр. лицо ООО Рога и Копыта");
        corp.addEmployeeNumber("+79990001111");
        corp.addEmployeeNumber("+79990002222");
        corp.setCreditLimit(50000.0);
        corp.calculateTotalCorporateBill();

        // Закрытие контракта
        System.out.println("\n--- 4. ЗАКРЫТИЕ СЧЕТА ---");
        citizen.closeAccountAndNumber();
    }
}
