// Базовый класс для всех сладостей
abstract class Confectionery {
    private final String name;
    private final double weight; // в граммах
    private final double sugarContent; // процент содержания сахара (0-100)

    public Confectionery(String name, double weight, double sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getSugarContent() { return sugarContent; }

    @Override
    public String toString() {
        return String.format("%s (Вес: %.1fg, Сахар: %.1f%%)", name, weight, sugarContent);
    }
}

