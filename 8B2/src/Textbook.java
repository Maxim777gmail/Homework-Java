import java.util.ArrayList;
import java.util.List;

// 8. Класс Учебник (главный агрегатор текста)
class Textbook implements TextComponent {
    private final List<TextBlock> blocks = new ArrayList<>();

    public void addBlock(TextBlock block) {
        blocks.add(block);
    }

    // Собирает все предложения из обычных абзацев (исключая листинги)
    public List<Sentence> getAllSentences() {
        List<Sentence> allSentences = new ArrayList<>();
        for (TextBlock block : blocks) {
            if (block instanceof Paragraph) {
                allSentences.addAll(((Paragraph) block).getSentences());
            }
        }
        return allSentences;
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (TextBlock block : blocks) {
            sb.append(block.getValue()).append("\n\n");
        }
        return sb.toString().trim();
    }
}
