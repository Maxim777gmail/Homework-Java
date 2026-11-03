import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rawText =
                "Строка в языке Java — это основной носитель текстовой информации.\n" +
                        "В отличие от языка Си это не массив символов типа char\n" +
                        "```\n" +
                        "public static void main(String[] args) {\n" +
                        "    System.out.println(\"Hello World\");\n" +
                        "}\n" +
                        "```\n" +
                        "а объект соответствующего класса.";

        System.out.println("--- Исходный текст обработан. Модель создана. --- \n");

        // 1. Парсинг текста в объектную структуру
        Textbook textbook = TextParser.parse(rawText);

        // 2. Получение всех предложений учебника
        List<Sentence> sentences = textbook.getAllSentences();

        // 3. Сортировка предложений по возрастанию количества слов
        sentences.sort(Comparator.comparingInt(Sentence::getWordCount));

        // 4. Вывод результата
        System.out.println("Предложения в порядке возрастания количества слов:");
        for (Sentence s : sentences) {
            System.out.printf("[%d слов(а)]: %s\n", s.getWordCount(), s.getValue());
        }
    }
}
