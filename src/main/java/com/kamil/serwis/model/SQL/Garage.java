package com.kamil.serwis.model.SQL;

import com.kamil.serwis.model.ModelBase;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class Garage extends ModelBase {

    private Short numberOfParkingPlace;

    private String name;


    Garage(){

    }

    @OneToOne
    private Adress adress;

    @OneToMany
    private List<ParkingPlace> parkingPlaces;


}
