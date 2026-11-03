import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем новогодний подарок
        NewYearGift myGift = new NewYearGift();

        // Создаем и добавляем различные сладости
        myGift.add(new ChocolateCandy("Тульский", 15.5, 45.0, "Темный"));
        myGift.add(new ChocolateCandy("Аленка", 20.0, 52.5, "Молочный"));
        myGift.add(new Lollipop("Петушок", 10.0, 85.0, "Карамельный"));
        myGift.add(new Lollipop("Дюшес", 12.0, 78.0, "Яблочный"));
        myGift.add(new JellyCandy("Мармелад", 8.5, 35.0, true));

        System.out.println("=== Исходный состав подарка ===");
        myGift.printGiftComposition();
        System.out.printf("Общий вес подарка: %.2f г\n\n", myGift.getTotalWeight());

        // Сортировка по весу
        System.out.println("=== Состав после сортировки по весу (возрастание) ===");
        myGift.sortByWeight();
        myGift.printGiftComposition();
        System.out.println();

        // Поиск сладостей по содержанию сахара
        double minSugar = 40.0;
        double maxSugar = 60.0;
        System.out.printf("=== Сладости с содержанием сахара от %.1f%% до %.1f%% ===\n", minSugar, maxSugar);
        List<Confectionery> filteredCandies = myGift.findCandiesBySugarRange(minSugar, maxSugar);

        if (filteredCandies.isEmpty()) {
            System.out.println("Конфеты с такими параметрами не найдены.");
        } else {
            filteredCandies.forEach(candy -> System.out.println(" Найдено: " + candy));
        }
    }
}
