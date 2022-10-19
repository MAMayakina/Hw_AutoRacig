package transport;

import Racig.Mechanic;
import Racig.Sponsor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Transport {
    public String type;
    private String brand;
    private String model;
    private double engineVolume;
    private int maxSpeed;
    public static final String UNKNOW_VALUES = "неизвестно";
    private static int counterOfTransport;
    private static Set<Transport> transportSet = new HashSet<>();
    private Set<Sponsor> sponsorsSet = new HashSet<>();
    private Set<Mechanic> myMechanics = new HashSet<>();


    public Transport(String brand, String model, double engineVolume, int maxSpeed) {
        this.brand = checkParametr(brand);
        this.model = checkParametr(model);
        if (!checkParametr(model).equals(UNKNOW_VALUES)) {
            transportSet.add(this);
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
        for (Mechanic mechanic : Mechanic.getMechanicsSet()) {
            if (mechanic.getTransportForMaintenance().contains(this)) {
                myMechanics.add(mechanic);
            }
        }
    }

    public void printMechanics() {
        fillMechanics();
        int commaCheck = myMechanics.size();
        for (Mechanic myMechanic : myMechanics) {
            if (commaCheck == myMechanics.size()) {
                System.out.print(myMechanic.getFirstName() + " " + myMechanic.getLastName() + " (" + myMechanic.getCompany() + ")");
            } else {
                System.out.print(", " + myMechanic.getFirstName() + " " + myMechanic.getLastName() + " (" + myMechanic.getCompany() + ")");
            }
            commaCheck--;
        }
        System.out.println();
    }

    public void printSponsors() {
        int commaCheck = sponsorsSet.size();
        for (Sponsor sponsor : sponsorsSet) {
            if (commaCheck == sponsorsSet.size()) {
                System.out.print(sponsor.getNameSponsor() + " выделяет сумму " + sponsor.getAmountOfSponsorship());
            } else {
                System.out.print(", " + sponsor.getNameSponsor() + " выделяет сумму " + sponsor.getAmountOfSponsorship());
            }
            commaCheck--;
        }
    }


    @Override
    public String toString() {
        return "бренд " + brand +
                ", модель " + model +
                ", объем двигателя " + engineVolume + "л" +
                ", макс.скорость " + maxSpeed + "км/ч" +
                ", спонсоры: " + getSponsorsSet();
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

    public static Set<Transport> getTransportSet() {
        return transportSet;
    }

    public Set<Sponsor> getSponsorsSet() {
        return sponsorsSet;
    }

    public Set getMyMechanics() {
        return myMechanics;
    }
}
