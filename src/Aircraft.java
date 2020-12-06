// Класс самолёта
public abstract class Aircraft extends Transport {

    public abstract void makeDive();

    public Aircraft() {
        System.out.println("---Самолёт создан---");
    }

    @Override
    public void move() {
        System.out.println("Самолёт летит");
    }
}
