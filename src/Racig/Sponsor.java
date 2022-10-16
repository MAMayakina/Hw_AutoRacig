package Racig;

import transport.Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Sponsor {
    private String nameSponsor;
    private boolean typeOfSponsor; // true - физ.лицо, 0 - компания
    private int amountOfSponsorship;
    private static ArrayList<Sponsor> sponsorsArrayList = new ArrayList<>(100);
    private ArrayList<Transport> transportForSponsorship = new ArrayList<Transport>(10);

    public Sponsor(String nameSponsor, boolean typeOfSponsor, int amountOfSponsorship) {
        if (nameSponsor != null && !nameSponsor.isEmpty() && !nameSponsor.isBlank()) {
            this.nameSponsor = nameSponsor;
            this.typeOfSponsor = typeOfSponsor;
            if (amountOfSponsorship > 0) {
                this.amountOfSponsorship = amountOfSponsorship;
            } else {
                this.amountOfSponsorship = 0;
            }
        }
    }

    private void fillTransportForSponsorship() {
        for (int i = 0; i < Transport.getTransportArrayList().size(); i++) {
            if (Transport.getTransportArrayList().get(i).getSponsorsArrayList().contains(this)) {
                transportForSponsorship.add(Transport.getTransportArrayList().get(i));
            }
        }
    }

    public void printTransportForSponsorship() {
        fillTransportForSponsorship();
        System.out.print(nameSponsor + " спонсирует в заезде "+ transportForSponsorship.get(0).getModel());
        for (int i = 1; i < transportForSponsorship.size(); i++) {
            System.out.print(", " + transportForSponsorship.get(i).getModel());
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Спонсор " + getNameSponsor() + ", сумма поддержки " + amountOfSponsorship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return typeOfSponsor == sponsor.typeOfSponsor && amountOfSponsorship == sponsor.amountOfSponsorship && Objects.equals(nameSponsor, sponsor.nameSponsor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSponsor, typeOfSponsor, amountOfSponsorship);
    }

    public String getNameSponsor() {
            return nameSponsor;

    }

    public void setNameSponsor(String name) {
        if (!name.isEmpty() && !name.isBlank()) {
            this.nameSponsor = name;
        }
    }

    public void setTypeOfSponsor(boolean typeOfSponsor) {
        this.typeOfSponsor = typeOfSponsor;
    }

    public int getAmountOfSponsorship() {
        return amountOfSponsorship;
    }

    public void setAmountOfSponsorship(int amountOfSponsorship) {
        if (amountOfSponsorship > 0) {
            this.amountOfSponsorship = amountOfSponsorship;
        }
    }

    public ArrayList<Sponsor> getSponsorsArrayList() {
        return sponsorsArrayList;
    }
}
