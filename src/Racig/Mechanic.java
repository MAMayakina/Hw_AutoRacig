package Racig;

import transport.Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Mechanic {
    private String firstName;
    private String lastName;
    private String company;
    private static int counterOfMechanics;
    private static ArrayList<Mechanic> mechanicsArrayList = new ArrayList<Mechanic>(1000);
    private ArrayList<Transport> transportForMaintenance = new ArrayList<Transport>(10);

    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        mechanicsArrayList.add(counterOfMechanics, this);
        counterOfMechanics++;
    }

    public void printTransportForMaintenance() {
        System.out.print("Я " + firstName + " " + lastName + " (" + company + ") и я обслуживаю транспорт " + transportForMaintenance.get(0).getModel());
        for (int i = 1; i < transportForMaintenance.size(); i++) {
            System.out.print(", " + transportForMaintenance.get(i).getModel());
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

    public static ArrayList<Mechanic> getMechanicsArrayList() {
        return mechanicsArrayList;
    }

    public ArrayList<Transport> getTransportForMaintenance() {
        return transportForMaintenance;
    }
}
