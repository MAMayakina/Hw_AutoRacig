import transport.Transport;

import java.time.LocalDate;
import java.util.Objects;


public class Driver<T extends Transport> {
    public static final String UNKNOW_VALUES = "неизвестно";
    private String name;
    public String typeLicense = UNKNOW_VALUES;
    private String transportLicense = UNKNOW_VALUES;
    private int yearOfIssueLicenseOfDriver;
    private String myTransport = UNKNOW_VALUES;


    public Driver(String name, int driverExperience) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;

            if (driverExperience < 0) {
                this.yearOfIssueLicenseOfDriver = LocalDate.now().getYear();
            } else {
                this.yearOfIssueLicenseOfDriver = LocalDate.now().getYear() - driverExperience;
            }
        }
    }

    public void defineTransport(T transport) {
        if ("Car".equals(transport.type)) {
            setTypeLicense("B");
            setMyTransport(transport.getModel());
        } else if ("Truck".equals(transport.type)) {
            setTypeLicense("C");
            setMyTransport(transport.getModel());
        } else if ("Bus".equals(transport.type)) {
            setTypeLicense("D");
            setMyTransport(transport.getModel());
        } else {
            setTypeLicense(UNKNOW_VALUES);
            setMyTransport(UNKNOW_VALUES);
        }
    }

    public void drive() {
        if (!getMyTransport().equals(UNKNOW_VALUES)) {
            System.out.println("Водитель " + getName() + " управляет " + getMyTransport() + " и будет участвовать в заезде.");
        } else {
            System.out.println("У водителя " + getName() + " нет транспортного средства.");
        }
    }


    public void startMovement() {
        System.out.println("Я " + this.name + " и я начинаю движение");
    }

    public void finishMovement() {
        System.out.println("Я " + this.name + " и я заканчиваю движение");
    }

    public void refuelTransport() {
        System.out.println("Я " + this.name + " и я заправляю мой транспорт");
    }

    @Override
    public String toString() {
        return "Водитель " + name +
                ", категория " + typeLicense +
                " (" + transportLicense + ")" +
                ", водительский стаж " + (LocalDate.now().getYear() - yearOfIssueLicenseOfDriver) + " лет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return yearOfIssueLicenseOfDriver == driver.yearOfIssueLicenseOfDriver && Objects.equals(name, driver.name) && Objects.equals(typeLicense, driver.typeLicense) && Objects.equals(transportLicense, driver.transportLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeLicense, transportLicense, yearOfIssueLicenseOfDriver);
    }

    public String getName() {
        return name;
    }

    public int getDriverExperience() {
        return LocalDate.now().getYear() - yearOfIssueLicenseOfDriver;
    }

    public String getTypeLicense() {
        return typeLicense;
    }

    private void setTypeLicense(String typeLicense) {
        switch (typeLicense) {
            case "B":
                this.typeLicense = typeLicense;
                this.transportLicense = "легковые автомобили";
                break;
            case "C":
                this.typeLicense = typeLicense;
                this.transportLicense = "грузовые автомобили";
                break;
            case "D":
                this.typeLicense = typeLicense;
                this.transportLicense = "автобусы";
                break;
            default:
                this.typeLicense = UNKNOW_VALUES;
                this.transportLicense = UNKNOW_VALUES;
        }
    }

    public String getTransportLicense() {
        return transportLicense;
    }

    public String getMyTransport() {
        return myTransport;
    }

    private void setMyTransport(String myTransport) {
        this.myTransport = myTransport;
    }
}
