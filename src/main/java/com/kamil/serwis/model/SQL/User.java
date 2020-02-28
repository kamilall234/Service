package com.kamil.serwis.model.SQL;


import com.kamil.serwis.model.ModelBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends ModelBase implements OwnerPlace{

    public User(){

    }

    public User(String userName){
        this.UserName = userName;
    }

    private String UserName;

    private boolean isOwnerPlace;

    @OneToMany
    private List<ParkingPlace> parkingPlaceList;

    @Override
    public boolean isOwnerPlace() {
        return false;
    }
}
