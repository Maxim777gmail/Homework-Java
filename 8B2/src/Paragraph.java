import java.util.ArrayList;
import java.util.List;

//Класс Абзац (состоит из предложений)
class Paragraph extends TextBlock {
    private final List<Sentence> sentences = new ArrayList<>();

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s.getValue()).append(" ");
        }
        return sb.toString().trim();
    }
}
