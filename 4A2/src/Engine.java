import java.util.Objects;

public class Engine {
    private String model;
    private int horsepower;

    public Engine(String model, int horsepower) {
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getModel() { return model; }
    public int getHorsepower() { return horsepower; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return horsepower == engine.horsepower && Objects.equals(model, engine.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, horsepower);
    }

    @Override
    public String toString() {
        return "Двигатель{модель='" + model + "', л.с.=" + horsepower + "}";
    }
}
