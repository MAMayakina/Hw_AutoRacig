import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Lada", "Lada Grante", 1.8, 180, "желтый");
        Car car2 = new Car("Audi", "Audi S8", 5.8, 280, "черный");
        Car car3 = new Car("BMW", "BMW Z8", 4.9, 260, "черный");
        Car car4 = new Car("Kia", "Kia Sportage 4", 2.0, 200, "красный");

        Truck truck1 = new Truck("ГАЗ", "ГАЗ-22107", 2.5, 120, 0.85);
        Truck truck2 = new Truck("Citroen", "Citroen Berlingo New", 1.9, 150, 0.8);
        Truck truck3 = new Truck("Volkswagen", "Volkswagen Crafter 35", 2, 160, 0.9);
        Truck truck4 = new Truck("Mersedes", "Mersedes-Benz Sprinter", 3, 170, 1);

        Bus bus1 = new Bus("ПАЗ", "ПАЗ-3204", 4.6, 110, 50);
        Bus bus2 = new Bus("Лиаз", "Лиаз-6213", 6.7, 90, 154);
        Bus bus3 = new Bus("Кавз", "Кавз-4270", 6.6, 100, 84);
        Bus bus4 = new Bus("МАЗ", "МАЗ-203", 6.4, 90, 102);

        DriverB<Car> driver1 = new DriverB<Car>("Владимир", 10);
        driver1.defineLicenseAndTransport(car1);
        DriverD<Bus> driver2 = new DriverD<Bus>("Евгений", 5);
        driver2.defineLicenseAndTransport(bus1);
        DriverC<Truck> driver3 = new DriverC<Truck>("Дмитрий", 15);
        driver3.defineLicenseAndTransport(truck3);
        DriverC<Truck> driver4 = new DriverC<Truck>("Михаил", 4);

        System.out.println("*** Общая информация:");
        System.out.println(car1);
        System.out.println(truck1);
        System.out.println(bus1);

        System.out.println();
        System.out.println("*** Проверка методов начинаю и заканчиваю движение:");
        car1.startMovement();
        car2.finishMovement();
        truck3.startMovement();
        truck4.finishMovement();
        bus1.startMovement();
        bus4.finishMovement();

        System.out.println();
        System.out.println("*** Проверка пит-стоп, лучшее время, макс.скорость:");
        car1.pitStop();
        car2.bestLapTime();
        car3.maxSpeedOnRace();
        truck1.pitStop();
        truck2.bestLapTime();
        truck3.maxSpeedOnRace();
        bus1.pitStop();
        bus2.bestLapTime();
        bus3.maxSpeedOnRace();

        System.out.println();
        System.out.println("*** Водители:");
        System.out.println(driver1);
        System.out.println(driver2);
        System.out.println(driver3);
        System.out.println(driver4);

        System.out.println();
        System.out.println("*** Участие в заезде:");
        driver1.drive();
        driver2.drive();
        driver3.drive();
        driver4.drive();

        System.out.println();
        System.out.println("*** Проверка методов водителя: начинаю движение, заканчиваю движение, заправляю транспорт:");
        driver1.startMovement();
        driver2.finishMovement();
        driver3.refuelTransport();

    }
}