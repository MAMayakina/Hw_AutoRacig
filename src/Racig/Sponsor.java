package Racig;

import transport.Transport;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sponsor {
    private String nameSponsor;
    private boolean typeOfSponsor; // true - физ.лицо, 0 - компания
    private int amountOfSponsorship;
    private static Set<Sponsor> sponsorsSet = new HashSet<>();
    private Set<Transport> transportForSponsorship = new HashSet<>();

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
        for (Transport transport : Transport.getTransportSet()) {
            if (transport.getSponsorsSet().contains(this)) {
                transportForSponsorship.add(transport);
            }
        }
    }

    public void printTransportForSponsorship() {
        fillTransportForSponsorship();
        int commaCheck = transportForSponsorship.size();
        System.out.print(nameSponsor + " спонсирует в заезде ");
        for (Transport transport : transportForSponsorship) {
            if (commaCheck == transportForSponsorship.size()) {
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

    public Set<Sponsor> getSponsorsSet() {
        return sponsorsSet;
    }
}
