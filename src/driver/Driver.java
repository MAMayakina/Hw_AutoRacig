package driver;


import Racig.Sponsor;
import transport.Competing;
import transport.NoPassDiagnosticExeption;
import transport.Transport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Driver<T extends Transport & Competing> {
    public static final String UNKNOW_VALUES = "неизвестно";
    private static int counterOfDriver;
    private String name;
    protected int yearOfIssueLicenseOfDriver;
    protected String typeLicense = UNKNOW_VALUES;
    protected String transportLicense = UNKNOW_VALUES;
    protected Transport myTransport;
    private static ArrayList<Driver> driversArrayList=new ArrayList<>(100);
    private ArrayList<Racig.Sponsor> sponsorsArrayList=new ArrayList<>(100);


    public Driver(String name, int driverExperience) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
            getDriversArrayList().add(counterOfDriver, this);
            counterOfDriver++;
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

    public void checkDriverLicense() throws RuntimeException{
        if(this.getTypeLicense().equals(UNKNOW_VALUES)){
            throw new RuntimeException("Необходимо указать тип прав!");
        }
    }

    @Override
    public String toString() {
        return "Водитель" + name +
                "(стаж " + (LocalDate.now().getYear() - yearOfIssueLicenseOfDriver) +
                ", кат." + typeLicense +
                " - " + transportLicense +
                ", транспорт - " + getMyTransport().getModel() + ")"+
           ", спонсоры: " + getMyTransport().getSponsorsArrayList() ;
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

    public Transport getMyTransport() {
        if (myTransport==null){}
        return myTransport;
    }

    private void setMyTransport(Transport myTransport) {
        this.myTransport = myTransport;
    }

    public static int getCounterOfDriver() {
        return counterOfDriver;
    }


    public static ArrayList<Driver> getDriversArrayList() {
        return driversArrayList;
    }

    public ArrayList<Sponsor> getSponsorsArrayList() {
        return getMyTransport().getSponsorsArrayList();
    }
}
