package driver;


import transport.Bus;
import transport.Transport;

import java.time.LocalDate;

public class DriverD<D extends Bus> extends Driver{
    public DriverD(String name, int driverExperience) {
        super(name,driverExperience);
    }

    public void defineLicenseAndTransport(D bus) {
        typeLicense = "D";
        transportLicense = "автобусы";
        myTransport = bus;
    }

    public void drive() {
        if (!getMyTransport().equals(UNKNOW_VALUES)) {
            System.out.println("Водитель автобуса " + getName() + " управляет " + getMyTransport().getModel() + " и будет участвовать в заезде.");
        } else {
            System.out.println("У водителя " + getName() + " нет автобуса.");
        }
    }

    public void startMovement() {
        System.out.println("Я водитель автобуса " + getName() + " и я начинаю движение");
    }

    public void finishMovement() {
        System.out.println("Я водитель автобуса " + getName() + " и я заканчиваю движение");
    }

    public void refuelTransport() {
        System.out.println("Я водитель автобуса " + getName() + " и я заправляю мой транспорт");
    }

    @Override
    public String toString() {
        return "Водитель автобуса " + getName() +
                " (стаж " + (LocalDate.now().getYear()-yearOfIssueLicenseOfDriver) +
                ", кат." + typeLicense +
                " - " + transportLicense +
                ", автобус " + getMyTransport().getModel() + ")"+
                ", спонсоры: " + getMyTransport().getSponsorsArrayList() ;
    }


}
