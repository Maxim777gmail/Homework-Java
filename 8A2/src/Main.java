public class Main {
    public static void main(String[] args) {
        String text = "задание"; // Входной текст (только русские буквы или с пробелами)
        text = text.toLowerCase(); // Приводим к нижнему регистру

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'а' && c <= 'я') {
                // Порядковый номер в русском алфавите: 'а' = 1, 'б' = 2, ..., 'я' = 33
                int position = c - 'а' + 1;
                String posStr = String.valueOf(position);

                line1.append(c).append("  ");
                // Достаточное количество пробелов или выравнивание под разрядность номера
                line2.append(posStr).append(" ".repeat(Math.max(1, 3 - posStr.length())));
            } else if (c == ' ') {
                line1.append("   ");
                line2.append("   ");
            }
        }

        System.out.println(line1.toString().trim());
        System.out.println(line2.toString().trim());
    }
}
