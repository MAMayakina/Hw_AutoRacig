package driver;

import transport.Car;

import java.time.LocalDate;

public class DriverB<B extends Car> extends Driver {
    public DriverB(String name, int driverExperience) {
        super(name, driverExperience);
    }

    public void defineLicenseAndTransport(B car) {
        typeLicense = "B";
        transportLicense = "легковые автомобили";
        myTransport = car;
    }

    public void drive() {
        if (!getMyTransport().equals(null)) {
            System.out.println("Водитель автомобиля " + getName() + " управляет " + getMyTransport().getModel() + " и будет участвовать в заезде.");
        } else {
            System.out.println("У водителя " + getName() + " нет автомобиля.");
        }
    }

    public void startMovement() {
        System.out.println("Я водитель автомобиля " + getName() + " и я начинаю движение");
    }

    public void finishMovement() {
        System.out.println("Я водитель автомобиля " + getName() + " и я заканчиваю движение");
    }

    public void refuelTransport() {
        System.out.println("Я водитель автомобиля " + getName() + " и я заправляю мой транспорт");
    }

    @Override
    public String toString() {
        return "Водитель автомобиля " + getName() +
                " (стаж " + (LocalDate.now().getYear() - yearOfIssueLicenseOfDriver) +
                ", кат." + typeLicense +
                " - " + transportLicense +
                ", автомобиль - " + getMyTransport().getModel() + ")"+
                ", спонсоры: " + getMyTransport().getSponsorsArrayList();
    }
}
