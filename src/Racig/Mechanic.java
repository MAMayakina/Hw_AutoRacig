package Racig;

import transport.Transport;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mechanic {
    private String firstName;
    private String lastName;
    private String company;
    private static int counterOfMechanics;
    private static Set<Mechanic> mechanicsSet = new HashSet<>();
    private Set<Transport> transportForMaintenance = new HashSet<>();

    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        mechanicsSet.add(this);
        counterOfMechanics++;
    }

    public void printTransportForMaintenance() {
        int commaCheck = transportForMaintenance.size();
        System.out.print("Я " + firstName + " " + lastName + " (" + company + ") и я обслуживаю транспорт ");
        for (Transport transport : transportForMaintenance) {
            if (commaCheck == transportForMaintenance.size()) {
                System.out.print(transport.getModel());
            } else {
                System.out.print(", " + transport.getModel());
            }
            commaCheck--;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Механик " + firstName +
                " " + lastName +
                " (компания <" + company + ">)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(firstName, mechanic.firstName) && Objects.equals(lastName, mechanic.lastName) && Objects.equals(company, mechanic.company) && Objects.equals(transportForMaintenance, mechanic.transportForMaintenance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, company, transportForMaintenance);
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company != null && !company.isEmpty() && !company.isBlank()) {
            this.company = company;
        }
    }

    public static Set<Mechanic> getMechanicsSet() {
        return mechanicsSet;
    }

    public Set<Transport> getTransportForMaintenance() {
        return transportForMaintenance;
    }
}
