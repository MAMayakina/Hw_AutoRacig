package transport;

import java.util.Objects;

public class Bus extends Transport implements Competing {
    public enum CapacityBus {
        ESPECIALLY_SMALL("особо малая", 10),
        SMALL("малая", 25),
        MEDIUM("средняя", 50),
        LARGE("большая", 80),
        ESPECIALLY_LARGE("особо большая", 120);

        private String capacity;
        private int maxNumber;

        CapacityBus(String capacity, int maxNumber) {
            this.capacity = capacity;
            this.maxNumber = maxNumber;
        }

        public String getCapacity() {
            return capacity;
        }

        public int getMaxNumber() {
            return maxNumber;
        }
    }

    private CapacityBus capacityBus;

    public Bus(String brand, String model, double engineVolume, int maxSpeed, CapacityBus capacityBus) {
        super(brand, model, engineVolume, maxSpeed);
        this.type = "Bus";
        this.capacityBus = capacityBus;
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

    public void bestLapTime() {
        System.out.println("Автобус " + getModel() + " показал лучшее время на круге");
    }

    public void maxSpeedOnRace() {
        System.out.println("Автобус " + getModel() + " достиг своей макс.скорости на гонке - " + getMaxSpeed() + "км/ч");
    }

    public String getTypeOfTransport() {
        if (capacityBus == null) {
            return "Данных по " + getModel() + "недостаточно";
        } else {
            return "Вместимость " + getModel() + " - " + capacityBus.capacity + " (макс. число мест " + capacityBus.maxNumber + ")";
        }
    }

    public void passDiagnostics() throws NoPassDiagnosticExeption {
       throw new NoPassDiagnosticExeption("Автобусу "+ this.getModel() +" диагностика не требуется");
    }

    @Override
    public String toString() {
        return "бренд " + getBrand() +
                ", модель " + getModel() +
                ", объем двигателя - " + getEngineVolume() + "л" +
                ", макс.скорость - " + getMaxSpeed() + "км/ч" +
                ", вместимость - " + capacityBus.capacity + " (макс. число мест " + capacityBus.maxNumber + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacityBus == bus.capacityBus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacityBus);
    }

    public CapacityBus getCapacityBus() {
        return capacityBus;
    }
}
