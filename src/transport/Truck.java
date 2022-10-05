package transport;

import java.util.Objects;

public class Truck extends Transport implements Competing {
    private double loadCapacity;

    public Truck(String brand, String model, double engineVolume, int maxSpeed, double loadCapacity) {
        super(brand, model, engineVolume, maxSpeed);
        this.type="Truck";
        if (!getBrand().equals(UNKNOW_VALUES) && !getModel().equals(UNKNOW_VALUES)) {
            if (loadCapacity < 0) {
                this.loadCapacity = 0;
            } else {
                this.loadCapacity = loadCapacity;
            }

        }
    }

    public void startMovement() {
        System.out.println("Грузовой автомобиль " + this.getModel() + " начинает движение");
    }

    public void finishMovement() {
        System.out.println("Грузовой автомобиль " + this.getModel() + " заканчивает движение");
    }

    public void pitStop() {
        System.out.println("Грузовик " + getModel() + " на пит-стопе");
    }

    public void bestLapTime() {
        System.out.println("Грузовик " + getModel() + " показал лучшее время на круге");
    }

    public void maxSpeedOnRace() {
        System.out.println("Грузовик " + getModel() + " достиг своей макс.скорости на гонке - " + getMaxSpeed() + "км/ч");
    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", объем двигателя " + getEngineVolume() + "л" +
                ", макс.скорость " + getMaxSpeed() + "км/ч" +
                ", грузоподъемность " + loadCapacity + "кг";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return loadCapacity == truck.loadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }
}
