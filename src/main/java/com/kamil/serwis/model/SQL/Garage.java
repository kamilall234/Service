package com.kamil.serwis.model.SQL;

import com.kamil.serwis.model.ModelBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Garage extends ModelBase {

    private Short numberOfParkingPlace;

    private String name;

    public Garage(){

    }

    @OneToOne
    private Adress adress;

    @OneToMany
    private List<ParkingPlace> parkingPlaces;

}
