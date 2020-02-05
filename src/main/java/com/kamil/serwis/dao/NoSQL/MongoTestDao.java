package com.kamil.serwis.dao.NoSQL;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MongoTestDao {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    private String id;

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
