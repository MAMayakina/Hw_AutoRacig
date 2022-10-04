package transport;

import java.util.Objects;

public class Bus extends Transport implements Competing {
    private int numberOfSeats;

    public Bus(String brand, String model, double engineVolume, int maxSpeed, int numberOfSeats) {
        super(brand, model, engineVolume, maxSpeed);
        this.type="Bus";
        if (!getBrand().equals(UNKNOW_VALUES) && !getModel().equals(UNKNOW_VALUES)) {
            if (numberOfSeats < 0) {
                this.numberOfSeats = 0;
            } else {
                this.numberOfSeats = numberOfSeats;
            }

        }
    }

    public void startMovement() {
        System.out.println("Автобус " + this.getModel() + " начинает движение");
    }

    public void finishMovement() {
        System.out.println("Автобус " + this.getModel() + " заканчивает движение");
    }

    public void pitStop() {
        System.out.println("Автобус " + getModel() + " на пит-стопе");
    }

    public void getBestLapTime() {
        System.out.println("Автобус " + getModel() + " показал лучшее время на круге");
    }

    public void getMaxSpeedOnRace() {
        System.out.println("Макс.скорость автобуса " + getModel() + " - " + getMaxSpeed() + "км/ч");
    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", объем двигателя " + getEngineVolume() + "л" +
                ", макс.скорость " + getMaxSpeed() + "км/ч" +
                ", вместимость " + numberOfSeats + "чел";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return numberOfSeats == bus.numberOfSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSeats);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
