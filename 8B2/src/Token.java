//Абстрактная Лексема (может быть Словом или Знаком препинания)
class Token implements TextComponent {
    private final TextComponent component;

    public Token(TextComponent component) {
        this.component = component;
    }

    public boolean isWord() {
        return component instanceof Word;
    }

    @Override
    public String getValue() {
        return component.getValue();
    }
}
