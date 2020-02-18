package com.kamil.serwis.model.SQL;


import com.kamil.serwis.model.ModelBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User extends ModelBase {

    public User(){

    }

    private String UserName;



}
