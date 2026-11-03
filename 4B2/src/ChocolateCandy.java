// Шоколадная конфета
class ChocolateCandy extends Confectionery {
    private final String chocolateType; // Молочный, горький, белый

    public ChocolateCandy(String name, double weight, double sugarContent, String chocolateType) {
        super(name, weight, sugarContent);
        this.chocolateType = chocolateType;
    }

    @Override
    public String toString() {
        return super.toString() + " [Шоколад: " + chocolateType + "]";
    }
}
