package telecom.interfaces;

import telecom.models.Contract;

// Базовые операции с аккаунтом и договором
public interface AccountManagement {
    Contract signContract(String clientData);
    void openAccountAndNumber(String phoneNumber);
    void editProfile(String name, String email);
    void closeAccountAndNumber();
}

