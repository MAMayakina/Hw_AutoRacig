package transport;

import java.util.Objects;

public class Truck extends Transport implements Competing {
    public enum LoadCapacity {
        N1("полная масса до 3,5т"),
        N2("полная масса свыше 3,5т до 12т"),
        N3("полная масса свыше 12т");

        private String loadCapacityString;

        LoadCapacity(String loadCapacityString) {
            this.loadCapacityString = loadCapacityString;
        }

        public String getLoadCapacityString() {
            return loadCapacityString;
        }
    }

    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, int maxSpeed, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, maxSpeed);
        this.type = "Truck";
        this.loadCapacity = loadCapacity;
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

    public String getTypeOfTransport() {
        if (loadCapacity == null) {
            return "Данных по " + getModel() + "недостаточно";
        } else {
            return "Грузоподъемность " + getModel() + " - " + loadCapacity + " (" + loadCapacity.loadCapacityString + ")";
        }

    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", объем двигателя - " + getEngineVolume() + "л" +
                ", макс.скорость - " + getMaxSpeed() + "км/ч" +
                ", грузоподъемность - " + loadCapacity + " (" + loadCapacity.loadCapacityString + ")";
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

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }
}
