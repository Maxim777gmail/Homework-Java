import java.util.ArrayList;
import java.util.List;

//Класс Предложение (состоит из лексем)
class Sentence implements TextComponent {
    private final List<Token> tokens = new ArrayList<>();

    public void addToken(Token token) {
        tokens.add(token);
    }

    // Подсчет количества слов в предложении
    public int getWordCount() {
        int count = 0;
        for (Token t : tokens) {
            if (t.isWord()) count++;
        }
        return count;
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            Token current = tokens.get(i);
            sb.append(current.getValue());

            // Добавляем пробел после слова, если дальше идет другое слово
            if (i < tokens.size() - 1) {
                Token next = tokens.get(i + 1);
                if (current.isWord() && next.isWord()) {
                    sb.append(" ");
                } else if (current.isWord() && !next.isWord() && !next.getValue().matches("[.,!?;:]")) {
                    // Если после слова идет не стандартный знак препинания, тоже нужен пробел
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
