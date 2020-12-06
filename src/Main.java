import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Actions actions = new Actions();

        actions.demonstrateEquality();
        actions.demonstrateSomeMethods();
        actions.demonstratePolymorphism();
        actions.demonstrateSerialization();
    }
}

class Actions {

    // Просто делает разделительную черту для удобства
    // чтения в консоли
    private void makeDividingLine() {
        System.out.println("-------------------------");
    }

    public void demonstrateEquality() {
        Mercedes mercedes1 = new Mercedes("AMG GT", 300);
        Mercedes mercedes2 = new Mercedes("AMG GT", 300);
        Mercedes mercedes3 = new Mercedes("CLS", 250, 300);

        // Проверка на равенство двух экземпляров одного класса
        System.out.println("Равенство между AMG GT и ещё одним AMG GT: "
                + mercedes1.equals(mercedes2));
        System.out.println("Равенство между AMG GT и CLS: "
                + mercedes1.equals(mercedes3));

        makeDividingLine();
    }

    public void demonstrateSomeMethods() {
        Boeing boeing = new Boeing("777", 900, 550);
        boeing.makeNoise();
        boeing.makeDive();

        makeDividingLine();

        // Демонстрация метода toString()
        System.out.println(boeing);

        makeDividingLine();

        Mercedes mercedes = new Mercedes("AMG GT", 300);

        // До изменения статического поля isSpeedLimit
        mercedes.changeSpeed();

        Mercedes.isSpeedLimit = true;

        // После изменения статического поля isSpeedLimit
        mercedes.changeSpeed();

        makeDividingLine();
    }

    public void demonstratePolymorphism() {
        // Список из двух классов-наследников транспорта
        List<Transport> transports = Arrays.asList(
                new Mercedes("CLS", 250),
                new Boeing("777", 900, 550));

        for (Transport transport : transports) {
            // Полиморфный вызов метода
            transport.move();
        }

        makeDividingLine();
    }

    public void demonstrateSerialization() {

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("transport.dat"))) {
            Boeing boeing = new Boeing("777", 900, 550);
            oos.writeObject(boeing);
            System.out.println("---Сериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("transport.dat")
        )) {
            Boeing boeing = (Boeing) ois.readObject();

            System.out.printf(
                    "Model: %s\nMax Speed: %d\nCount of passengers: %s\n",
                    boeing.getModel(),
                    boeing.getMaxSpeed(),
                    boeing.getCountOfPassengers());

            System.out.println("---Десериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}