import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String str1, String str2) {
        // Быстрая проверка по длине
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("кот", "ток")); // является
        System.out.println(isAnagram("соль", "лось")); // является
        System.out.println(isAnagram("машина", "шиномонтаж")); // не является
    }
}
