package telecom.interfaces;

import telecom.models.Tariff;

// Финансовые операции и смена тарифов
public interface ServiceManagement {
    void changeTariff(Tariff newTariff);
    void changeOperator(String newOperatorName);
    void topUpBalance(double amount);
}
