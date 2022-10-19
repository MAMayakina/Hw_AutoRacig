import Racig.Mechanic;
import Racig.ServiceStation;
import Racig.Sponsor;
import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;
import transport.Bus.CapacityBus;
import transport.Car.BodyType;
import transport.Truck.LoadCapacity;

import static Racig.Mechanic.*;


public class Main {

    public static void doDiagnostics() throws NoPassDiagnosticExeption {
        for (Transport transport : Transport.getTransportSet()) {
            try {
                transport.passDiagnostics();
            } catch (NoPassDiagnosticExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkDriverLicense() throws NoPassDiagnosticExeption {
        for (Driver driver : Driver.getDriversArrayList()) {
            driver.checkDriverLicense();
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

        //Спонсоры
        System.out.println("***** Спонсоры");
        Sponsor sponsor1 = new Sponsor("Петр", true, 10000);
        Sponsor sponsor2 = new Sponsor("Иван", true, 50000);
        Sponsor sponsor3 = new Sponsor("ООО Ромашка", false, 200000);

        car1.getSponsorsSet().add(sponsor1);
        car1.getSponsorsSet().add(sponsor2);
        bus1.getSponsorsSet().add(sponsor3);
        truck1.getSponsorsSet().add(sponsor3);

        sponsor1.printTransportForSponsorship();
        sponsor2.printTransportForSponsorship();
        sponsor3.printTransportForSponsorship();

        car1.printSponsors();
        bus1.printSponsors();
        truck1.printSponsors();

        //Механики
        System.out.println();
        System.out.println("***** Механики");
        Mechanic mechanic1 = new Mechanic("Виктор", "Игнатьев", "Руль, колеса, фары");
        Mechanic mechanic2 = new Mechanic("Олег", "Боков", "Не тормози");
        Mechanic mechanic3 = new Mechanic("Юрий", "Красилов", "Лучшие в своем деле");
        Mechanic mechanic4 = new Mechanic("Виктор", "Игнатьев", "Руль, колеса, фары");
        mechanic1.getTransportForMaintenance().add(car1);
        mechanic2.getTransportForMaintenance().add(truck1);
        mechanic3.getTransportForMaintenance().add(truck1);
        mechanic3.getTransportForMaintenance().add(bus1);

        System.out.println();
        System.out.println("Попытка вывести дубль механика "+ getMechanicsSet());
        System.out.println();

        mechanic1.printTransportForMaintenance();
        mechanic2.printTransportForMaintenance();
        mechanic3.printTransportForMaintenance();

        car1.printMechanics();
        truck1.printMechanics();
        bus1.printMechanics();

        //Общая информация по  транспорту и водителям
        System.out.println();
        System.out.println("***** Общая информация по  транспорту и водителям");
        System.out.println(car1);
        System.out.println(bus1);
        System.out.println(truck1);
        System.out.println(driver1);
        System.out.println(driver2);
        System.out.println(driver3);

        //Тех.осмотр
        System.out.println();
        System.out.println("***** Тех.осмотр");
        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addTransportToServiceStation(car1);
        serviceStation.addTransportToServiceStation(car2);
        serviceStation.addTransportToServiceStation(car3);
        serviceStation.addTransportToServiceStation(car4);
        serviceStation.addTransportToServiceStation(truck1);
        serviceStation.addTransportToServiceStation(truck2);
        serviceStation.addTransportToServiceStation(truck3);
        serviceStation.addTransportToServiceStation(truck4);
        serviceStation.addTransportToServiceStation(bus1);
        serviceStation.passService();

    }
}