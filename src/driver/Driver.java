package driver;


import transport.Competing;
import transport.Transport;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Driver<T extends Transport & Competing> {
    public static final String UNKNOW_VALUES = "неизвестно";
    private String name;
    protected int yearOfIssueLicenseOfDriver;
    protected String typeLicense = UNKNOW_VALUES;
    protected String transportLicense = UNKNOW_VALUES;
    protected String myTransport = UNKNOW_VALUES;


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

    public abstract void drive();

    public abstract void startMovement();

    public abstract void finishMovement();

    public abstract void refuelTransport();

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", yearOfIssueLicenseOfDriver=" + yearOfIssueLicenseOfDriver +
                ", typeLicense='" + typeLicense + '\'' +
                ", transportLicense='" + transportLicense + '\'' +
                ", myTransport='" + myTransport + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return yearOfIssueLicenseOfDriver == driver.yearOfIssueLicenseOfDriver && Objects.equals(name, driver.name) && Objects.equals(typeLicense, driver.typeLicense) && Objects.equals(transportLicense, driver.transportLicense) && Objects.equals(myTransport, driver.myTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfIssueLicenseOfDriver, typeLicense, transportLicense, myTransport);
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
