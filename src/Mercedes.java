import java.util.Objects;

// Класс Мерседеса
public class Mercedes extends Auto implements Noisable {

    private final String model;
    private final int maxSpeed;
    private int horsepower = 0;

    // Пример статического поля
    public static boolean isSpeedLimit = false;

    public Mercedes(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public Mercedes(String model, int maxSpeed, int horsepower) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.horsepower = horsepower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mercedes)) return false;
        Mercedes mercedes = (Mercedes) o;

        if (horsepower == 0) {
            return maxSpeed == mercedes.maxSpeed &&
                    model.equals(mercedes.model);
        }

        return maxSpeed == mercedes.maxSpeed &&
                horsepower == mercedes.horsepower &&
                model.equals(mercedes.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, horsepower);
    }

    @Override
    public String toString() {
        if (horsepower == 0) {
            return "Mercedes{" +
                    "model='" + model + '\'' +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }

        return "Mercedes{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", horsepower=" + horsepower +
                '}';
    }

    @Override
    void changeSpeed() {
        // Использование статического поля в условии
        if (!isSpeedLimit) {
            System.out.println("Мерседес разгоняется");
        } else {
            System.out.println("Мерседес тормозит");
        }
    }

    @Override
    public void makeNoise() {
        System.out.println("Мерседес издает шум в 50 дб");
    }
}