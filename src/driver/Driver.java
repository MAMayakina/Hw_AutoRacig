package driver;


import transport.Competing;
import transport.NoPassDiagnosticExeption;
import transport.Transport;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class Driver<T extends Transport & Competing> {
    public static final String UNKNOW_VALUES = "неизвестно";
    private static int counterOfDriver;
    private String name;
    protected int yearOfIssueLicenseOfDriver;
    protected String typeLicense = UNKNOW_VALUES;
    protected String transportLicense = UNKNOW_VALUES;
    protected String myTransport = UNKNOW_VALUES;
    private static Driver[] ArrayOfDriver = new Driver[0];


    public Driver(String name, int driverExperience) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
            addNewDriver(this);
            counterOfDriver++;
            if (driverExperience < 0) {
                this.yearOfIssueLicenseOfDriver = LocalDate.now().getYear();
            } else {
                this.yearOfIssueLicenseOfDriver = LocalDate.now().getYear() - driverExperience;
            }
        }
    }

    private static void addNewDriver(Driver driver) {
        ArrayOfDriver = Arrays.copyOf(ArrayOfDriver, getCounterOfDriver() + 1);
        ArrayOfDriver[getCounterOfDriver()] = driver;
    }

    public abstract void drive();

    public abstract void startMovement();

    public abstract void finishMovement();

    public abstract void refuelTransport();

    public void checkDriverLicense() throws RuntimeException{
        if(this.getTypeLicense().equals(UNKNOW_VALUES)){
            throw new RuntimeException("Необходимо указать тип прав!");
        }
    }

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

    public static int getCounterOfDriver() {
        return counterOfDriver;
    }

    public static Driver[] getArrayOfDriver() {
        return ArrayOfDriver;
    }
}
