// Леденец
class Lollipop extends Confectionery {
    private final String flavor; // Клубничный, лимонный и т.д.

    public Lollipop(String name, double weight, double sugarContent, String flavor) {
        super(name, weight, sugarContent);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return super.toString() + " [Вкус: " + flavor + "]";
    }
}
