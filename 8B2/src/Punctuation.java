//Класс Знак препинания
class Punctuation implements TextComponent {
    private final String value;

    public Punctuation(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
