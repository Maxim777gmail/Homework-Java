//Класс Символ
class Symbol implements TextComponent {
    private final char value;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
