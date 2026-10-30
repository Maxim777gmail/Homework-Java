// Класс, содержащий информацию о покупателе
class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private long creditCardNumber;
    private String bankAccountNumber;

    // Конструктор 1: Без параметров (по умолчанию)
    public Customer() {
    }

    // Конструктор 2: С базовыми данными (ФИО и ID)
    public Customer(int id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Конструктор 3: Полный конструктор со всеми параметрами
    public Customer(int id, String lastName, String firstName, String middleName,
                    String address, long creditCardNumber, String bankAccountNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    // Методы setТип() и getТип()
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public long getCreditCardNumber() { return creditCardNumber; }
    public void setCreditCardNumber(long creditCardNumber) { this.creditCardNumber = creditCardNumber; }

    public String getBankAccountNumber() { return bankAccountNumber; }
    public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }

    // Метод toString() для красивого вывода информации об объекте
    @Override
    public String toString() {
        return String.format("ID: %d | %s %s %s | Адрес: %s | Карта: %d | Счёт: %s",
                id, lastName, firstName, middleName, address, creditCardNumber, bankAccountNumber);
    }
}
