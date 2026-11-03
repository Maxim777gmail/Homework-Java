import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Парсер текста для построения объектной модели
class TextParser {

    public static Textbook parse(String text) {
        Textbook textbook = new Textbook();

        // Предварительно нормализуем пробелы и табуляции (заменяем на один пробел)
        // Но сохраняем переносы строк для деления на абзацы/листинги
        String normalizedText = text.replaceAll("[ \\t]+", " ");

        // Разделяем текст по строкам для определения блоков
        String[] lines = normalizedText.split("\\n");

        StringBuilder currentParagraphText = new StringBuilder();
        StringBuilder currentListingText = new StringBuilder();
        boolean insideListing = false;

        for (String line : lines) {
            String trimmed = line.trim();

            // Условный маркер начала/конца листинга кода в учебнике (например, ```)
            if (trimmed.startsWith("```")) {
                if (insideListing) {
                    textbook.addBlock(new Listing(currentListingText.toString().trim()));
                    currentListingText.setLength(0);
                    insideListing = false;
                } else {
                    if (currentParagraphText.length() > 0) {
                        textbook.addBlock(parseParagraph(currentParagraphText.toString()));
                        currentParagraphText.setLength(0);
                    }
                    insideListing = true;
                }
                continue;
            }

            if (insideListing) {
                currentListingText.append(line).append("\n");
            } else {
                if (trimmed.isEmpty()) {
                    if (currentParagraphText.length() > 0) {
                        textbook.addBlock(parseParagraph(currentParagraphText.toString()));
                        currentParagraphText.setLength(0);
                    }
                } else {
                    currentParagraphText.append(line).append(" ");
                }
            }
        }

        // Дозаписываем остатки
        if (insideListing) {
            textbook.addBlock(new Listing(currentListingText.toString().trim()));
        } else if (currentParagraphText.length() > 0) {
            textbook.addBlock(parseParagraph(currentParagraphText.toString()));
        }

        return textbook;
    }

    private static Paragraph parseParagraph(String paragraphStr) {
        Paragraph paragraph = new Paragraph();

        // Регулярное выражение для деления на предложения (учитываем . ! ?)
        Pattern sentencePattern = Pattern.compile("[^.!?]+([.!?]+|$)");
        Matcher matcher = sentencePattern.matcher(paragraphStr);

        while (matcher.find()) {
            String sentenceStr = matcher.group().trim();
            if (!sentenceStr.isEmpty()) {
                paragraph.addSentence(parseSentence(sentenceStr));
            }
        }
        return paragraph;
    }

    private static Sentence parseSentence(String sentenceStr) {
        Sentence sentence = new Sentence();

        // Регулярное выражение выделяет либо слова (буквы/цифры), либо знаки препинания
        Pattern tokenPattern = Pattern.compile("[\\wА-яёЁ]+|[^\\wА-яёЁ\\s]");
        Matcher matcher = tokenPattern.matcher(sentenceStr);

        while (matcher.find()) {
            String tokenStr = matcher.group();
            if (tokenStr.matches("[\\wА-яёЁ]+")) {
                sentence.addToken(new Token(new Word(tokenStr)));
            } else {
                sentence.addToken(new Token(new Punctuation(tokenStr)));
            }
        }
        return sentence;
    }
}

