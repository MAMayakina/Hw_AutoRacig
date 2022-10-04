package transport;

import java.util.Objects;

public class Car extends Transport implements Competing {
    private String color;

    public Car(String brand, String model, double engineVolume, int maxSpeed, String color) {
        super(brand, model, engineVolume, maxSpeed);
        if (!getBrand().equals(UNKNOW_VALUES) && !getModel().equals(UNKNOW_VALUES)) {
            this.color = checkParametr(color);
            this.type="Car";
        }

    }

    public void startMovement() {
        System.out.println("Легковой автомобиль " + this.getModel() + " начинает движение");
    }

    public void finishMovement() {
        System.out.println("Легковой автомобиль " + this.getModel() + " заканчивает движение");
    }


    public void pitStop() {
        System.out.println("Автомобиль " + getModel() + " на пит-стопе");
    }

    public void getBestLapTime() {
        System.out.println("Автомобиль " + getModel() + " показал лучшее время на круге");
    }

    public void getMaxSpeedOnRace() {
        System.out.println("Макс.скорость автомобиля " + getModel() + " - " + getMaxSpeed() + "км/ч");
    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", объем двигателя " + getEngineVolume() + "л" +
                ", макс.скорость " + getMaxSpeed() + "км/ч" +
                ", цвет " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.isEmpty() && !color.isBlank()) {
            this.color = color;
        }
    }
}
