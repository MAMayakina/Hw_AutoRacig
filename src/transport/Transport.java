package transport;

import java.util.Arrays;
import java.util.Objects;

public abstract class Transport {
    public static final String UNKNOW_VALUES = "неизвестно";
    private static int counterOfTransport;
    public String type;
    private String brand;
    private String model;
    private double engineVolume;
    private int maxSpeed;
    private static Transport[] ArrayOfTransport = new Transport[0];

    public Transport(String brand, String model, double engineVolume, int maxSpeed) {
        this.brand = checkParametr(brand);
        this.model = checkParametr(model);
        if (!checkParametr(model).equals(UNKNOW_VALUES)) {
            addNewTransport(this);
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

    private static void addNewTransport(Transport transport) {
        ArrayOfTransport = Arrays.copyOf(ArrayOfTransport, getCounterOfTransport() + 1);
        ArrayOfTransport[getCounterOfTransport()] = transport;
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


    @Override
    public String toString() {
        return "бренд " + brand +
                ", модель " + model +
                ", объем двигателя " + engineVolume + "л" +
                ", макс.скорость " + maxSpeed + "км/ч";
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

    public static Transport[] getArrayOfTransport() {
        return ArrayOfTransport;
    }
}
