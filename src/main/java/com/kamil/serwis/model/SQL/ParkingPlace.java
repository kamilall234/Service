package com.kamil.serwis.model.SQL;

import com.kamil.serwis.model.ModelBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ParkingPlace extends ModelBase {

    private Integer numberInGarage;

    @ManyToOne
    private Garage garage;

    @ManyToOne
    private User ownerPlace;

    public ParkingPlace() {
    }

    public Integer getNumberInGarage() {
        return numberInGarage;
    }

    public void setNumberInGarage(Integer numberInGarage) {
        this.numberInGarage = numberInGarage;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public OwnerPlace getOwnerPlace() {
        return ownerPlace;
    }

    public void setOwnerPlace(User ownerPlace) {
        this.ownerPlace = ownerPlace;
    }
}
