package transport;

import Racig.Mechanic;
import Racig.Sponsor;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Transport{
    public String type;
    private String brand;
    private String model;
    private double engineVolume;
    private int maxSpeed;
    public static final String UNKNOW_VALUES = "неизвестно";
    private static int counterOfTransport;
    private static ArrayList<Transport> transportArrayList = new ArrayList<>(100);
    private ArrayList<Sponsor> sponsorsArrayList = new ArrayList<Sponsor>(100);
    private ArrayList<Mechanic> myMechanics = new ArrayList<Mechanic>(10);


    public Transport(String brand, String model, double engineVolume, int maxSpeed) {
        this.brand = checkParametr(brand);
        this.model = checkParametr(model);
        if (!checkParametr(model).equals(UNKNOW_VALUES)) {
            transportArrayList.add(counterOfTransport, this);
            counterOfTransport++;
        }
        if (!this.brand.equals(UNKNOW_VALUES) && !this.model.equals(UNKNOW_VALUES)) {
            if (engineVolume < 0) {
                this.engineVolume = 0;
            } else {
                this.engineVolume = engineVolume;
            }
            if (maxSpeed < 0) {
                this.maxSpeed = 0;
            } else {
                this.maxSpeed = maxSpeed;
            }
        }
    }


    protected String checkParametr(String parametr) {
        if (parametr != null && !parametr.isEmpty() && !parametr.isBlank()) {
            return parametr;
        } else return UNKNOW_VALUES;
    }

    public abstract void startMovement();

    public abstract void finishMovement();

    public void pitStop() {
        System.out.println("Транспорт " + model + " на пит-стопе");
    }

    public void bestLapTime() {
        System.out.println("Транспорт " + model + " показал лучшее время на круге");
    }

    public void maxSpeedOnRace() {
        System.out.println(model + " достиг своей макс.скорости на гонке - " + getMaxSpeed() + "км/ч");
    }

    public abstract String getTypeOfTransport();

    public abstract void passDiagnostics() throws NoPassDiagnosticExeption;

    protected void fillMechanics() {
        for (int i = 0; i < Mechanic.getMechanicsArrayList().size(); i++) {
            if (Mechanic.getMechanicsArrayList().get(i).getTransportForMaintenance().contains(this)) {
                myMechanics.add(Mechanic.getMechanicsArrayList().get(i));
            }
        }
    }

    public void printMechanics() {
        fillMechanics();
        System.out.print("Механики " + this.getModel() + ": " + myMechanics.get(0).getFirstName() + " " + myMechanics.get(0).getLastName() + " (" + myMechanics.get(0).getCompany() + ")");
        for (int i = 1; i < myMechanics.size(); i++) {
            System.out.print(", " + myMechanics.get(i).getFirstName() + " " + myMechanics.get(i).getLastName() + " (" + myMechanics.get(i).getCompany() + ")");
        }
        System.out.println();
    }

    public void printSponsors() {
        System.out.print("Спонсоры " + this.getModel() + ": " + sponsorsArrayList.get(0).getNameSponsor() + " на сумму " + sponsorsArrayList.get(0).getAmountOfSponsorship());
        for (int i = 1; i < sponsorsArrayList.size(); i++) {
            System.out.print(", " + sponsorsArrayList.get(i).getNameSponsor() + " на сумму " + sponsorsArrayList.get(0).getAmountOfSponsorship());
        }
        System.out.println();

    }


    @Override
    public String toString() {
        return "бренд " + brand +
                ", модель " + model +
                ", объем двигателя " + engineVolume + "л" +
                ", макс.скорость " + maxSpeed + "км/ч" +
                ", спонсоры: " + getSponsorsArrayList() /*+
                ", механики: " + this.mechanicsArrayList()*/;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && maxSpeed == transport.maxSpeed && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, maxSpeed);
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (this.engineVolume <= 0 && engineVolume > 0) {
            this.engineVolume = engineVolume;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public static int getCounterOfTransport() {
        return counterOfTransport;
    }

    public static ArrayList<Transport> getTransportArrayList() {
        return transportArrayList;
    }

    public ArrayList<Sponsor> getSponsorsArrayList() {
        return sponsorsArrayList;
    }

    public ArrayList getMyMechanics() {
        return myMechanics;
    }
}
