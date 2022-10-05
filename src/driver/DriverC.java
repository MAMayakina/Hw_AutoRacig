package driver;

import transport.Transport;
import transport.Truck;

import java.time.LocalDate;

public class DriverC<C extends Truck> extends Driver{
    public DriverC(String name, int driverExperience) {
        super(name,driverExperience);
    }

    public void defineLicenseAndTransport(C truck) {
        typeLicense = "C";
        transportLicense = "грузовики";
        myTransport = truck.getModel();
    }

    public void drive() {
        if (!getMyTransport().equals(UNKNOW_VALUES)) {
            System.out.println("Водитель грузовика " + getName() + " управляет " + getMyTransport() + " и будет участвовать в заезде.");
        } else {
            System.out.println("У водителя " + getName() + " нет грузовика.");
        }
    }

    public void startMovement() {
        System.out.println("Я водитель грузовика " + getName() + " и я начинаю движение");
    }

    public void finishMovement() {
        System.out.println("Я водитель грузовика " + getName() + " и я заканчиваю движение");
    }

    public void refuelTransport() {
        System.out.println("Я водитель грузовика " + getName() + " и я заправляю мой транспорт");
    }

    @Override
    public String toString() {
        return "Водитель грузовика " + getName() +
                ", стаж " + (LocalDate.now().getYear()-yearOfIssueLicenseOfDriver) +
                ", категория " + typeLicense +
                " (" + transportLicense + ")" +
                ", мой грузовик " + myTransport;
    }
}
