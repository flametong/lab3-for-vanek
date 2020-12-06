// Класс автомобиля
public abstract class Auto extends Transport {

    abstract void changeSpeed();

    public Auto() {
        System.out.println("---Автомобиль создан---");
    }

    @Override
    public void move() {
        System.out.println("Автомобиль едет по дороге");
    }
}
