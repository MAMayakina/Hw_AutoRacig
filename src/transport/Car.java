package transport;

import java.util.Objects;


public class Car extends Transport implements Competing {

    public enum BodyType {
        SEDAN("седан"),
        HATCHBACK("хетчбек"),
        COUPE("купе"),
        STATION_WAGON("универсал"),
        OFFROAD_CAR("внедорожник"),
        CROSSOVER("кроссовер"),
        PICKUP("пикап"),
        VAN("фургон"),
        MINIVAN("минивен");

        private String type;

        BodyType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private String color;
    private BodyType bodyType;

    public Car(String brand, String model, BodyType bodyType, double engineVolume, int maxSpeed, String color) {
        super(brand, model, engineVolume, maxSpeed);

        if (!getBrand().equals(UNKNOW_VALUES) && !getModel().equals(UNKNOW_VALUES)) {
            this.color = checkParametr(color);
            this.bodyType = bodyType;
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

    public void bestLapTime() {
        System.out.println("Автомобиль " + getModel() + " показал лучшее время на круге");
    }

    public void maxSpeedOnRace() {
        System.out.println("Автомобиль " + getModel() + " достиг своей макс.скорости на гонке - " + getMaxSpeed() + "км/ч");
    }

    public String getTypeOfTransport() {
        if (bodyType == null) {
            return "Данных по " + getModel() + "недостаточно";
        } else {
            return "Тип кузова " + getModel() + " - " + bodyType.type;
        }

    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", тип кузова - " + bodyType.type +
                ", объем двигателя - " + getEngineVolume() + "л" +
                ", макс.скорость - " + getMaxSpeed() + "км/ч" +
                ", цвет - " + color;
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

    public BodyType getBodyType() {
        return bodyType;
    }
}
