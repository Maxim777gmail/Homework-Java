package telecom.interfaces;

import telecom.models.PaymentInfo;
import java.util.List;

// Операции проверки состояния и получения информации
public interface InfoService {
    String getNumberDetails();
    double checkBalance();
    int checkRemainingTraffic(); // в МБ
    List<PaymentInfo> getPaymentHistory();
}

