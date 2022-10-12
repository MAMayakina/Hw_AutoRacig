import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;
import transport.Bus.CapacityBus;
import transport.Car.BodyType;
import transport.Truck.LoadCapacity;

public class Main {

    public static void doDiagnostics() throws NoPassDiagnosticExeption {
        for (int i = 0; i < Transport.getArrayOfTransport().length; i++) {
            try {
                Transport.getArrayOfTransport()[i].passDiagnostics();
            } catch (NoPassDiagnosticExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkDriverLicense() throws NoPassDiagnosticExeption {
        for (int i = 0; i < Driver.getArrayOfDriver().length; i++) {
            Driver.getArrayOfDriver()[i].checkDriverLicense();
        }
    }

    public static void main(String[] args) throws NoPassDiagnosticExeption {
        Car car1 = new Car("Lada", "Lada Grante", BodyType.SEDAN, 1.8, 180, "желтый");
        Car car2 = new Car("Audi", "Audi S8", BodyType.SEDAN, 5.8, 280, "черный");
        Car car3 = new Car("BMW", "BMW Z8", BodyType.COUPE, 4.9, 260, "черный");
        Car car4 = new Car("Kia", "Kia Sportage 4", BodyType.CROSSOVER, 2.0, 200, "красный");

        Truck truck1 = new Truck("ГАЗ", "ГАЗ-22107", 2.5, 120, LoadCapacity.N2);
        Truck truck2 = new Truck("Citroen", "Citroen Berlingo New", 1.9, 150, LoadCapacity.N1);
        Truck truck3 = new Truck("Volkswagen", "Volkswagen Crafter 35", 2, 160, LoadCapacity.N1);
        Truck truck4 = new Truck("Mersedes", "Mersedes-Benz Sprinter", 3, 170, LoadCapacity.N1);

        Bus bus1 = new Bus("ПАЗ", "ПАЗ-3204", 4.6, 110, CapacityBus.MEDIUM);
        Bus bus2 = new Bus("Лиаз", "Лиаз-6213", 6.7, 90, CapacityBus.ESPECIALLY_LARGE);
        Bus bus3 = new Bus("Кавз", "Кавз-4270", 6.6, 100, CapacityBus.LARGE);
        Bus bus4 = new Bus("МАЗ", "МАЗ-203", 6.4, 90, CapacityBus.ESPECIALLY_LARGE);

        DriverB<Car> driver1 = new DriverB<Car>("Владимир", 10);
        driver1.defineLicenseAndTransport(car1);
        DriverD<Bus> driver2 = new DriverD<Bus>("Евгений", 5);
        driver2.defineLicenseAndTransport(bus1);
        DriverC<Truck> driver3 = new DriverC<Truck>("Дмитрий", 15);
        driver3.defineLicenseAndTransport(truck3);
        DriverC<Truck> driver4 = new DriverC<Truck>("Михаил", 4);
        //driver4.defineLicenseAndTransport(truck4);


        doDiagnostics();

        checkDriverLicense();
    }
}