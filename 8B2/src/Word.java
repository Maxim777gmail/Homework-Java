import java.util.ArrayList;
import java.util.List;

//Класс Слово (состоит из символов)
class Word implements TextComponent {
    private final List<Symbol> symbols = new ArrayList<>();

    public Word(String wordStr) {
        for (char c : wordStr.toCharArray()) {
            symbols.add(new Symbol(c));
        }
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : symbols) {
            sb.append(s.getValue());
        }
        return sb.toString();
    }
}
