import java.util.Objects;

public class Wheel {
    private int diameter;
    private String season; // например, "Зимняя" или "Летняя"

    public Wheel(int diameter, String season) {
        this.diameter = diameter;
        this.season = season;
    }

    public int getDiameter() { return diameter; }
    public String getSeason() { return season; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter && Objects.equals(season, wheel.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter, season);
    }

    @Override
    public String toString() {
        return "Колесо{диаметр=" + diameter + ", сезон='" + season + "'}";
    }
}
