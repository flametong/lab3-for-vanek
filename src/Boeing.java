import java.io.Serializable;
import java.util.Objects;

// Класс Боинга (сериализуемый)
public class Boeing extends Aircraft implements Serializable, Noisable {

    private final String model;
    private final int maxSpeed;
    private final int countOfPassengers;

    public Boeing(String model, int maxSpeed, int countOfPassengers) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.countOfPassengers = countOfPassengers;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boeing)) return false;
        Boeing boeing = (Boeing) o;
        return maxSpeed == boeing.maxSpeed &&
                countOfPassengers == boeing.countOfPassengers &&
                model.equals(boeing.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, countOfPassengers);
    }

    @Override
    public String toString() {
        return "Boeing{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", countOfPassengers=" + countOfPassengers +
                '}';
    }

    @Override
    public void makeDive() {
        System.out.println("Боинг делает пике");
    }

    @Override
    public void makeNoise() {
        System.out.println("Боинг издает шум в 140 дб");
    }
}