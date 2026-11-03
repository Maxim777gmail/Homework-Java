import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class NewYearGift {
    private final List<Confectionery> candies = new ArrayList<>();

    // Добавление сладости в подарок
    public void add(Confectionery candy) {
        candies.add(candy);
    }

    // Подсчет общего веса подарка
    public double getTotalWeight() {
        return candies.stream().mapToDouble(Confectionery::getWeight).sum();
    }

    // Сортировка конфет по весу (можно изменить на любой другой параметр)
    public void sortByWeight() {
        candies.sort(Comparator.comparingDouble(Confectionery::getWeight));
    }

    // Поиск конфет по диапазону содержания сахара
    public List<Confectionery> findCandiesBySugarRange(double minSugar, double maxSugar) {
        return candies.stream()
                .filter(c -> c.getSugarContent() >= minSugar && c.getSugarContent() <= maxSugar)
                .collect(Collectors.toList());
    }

    // Вывод состава подарка
    public void printGiftComposition() {
        if (candies.isEmpty()) {
            System.out.println("Подарок пуст.");
            return;
        }
        candies.forEach(candy -> System.out.println(" - " + candy));
    }
}
