package com.kamil.serwis.dao.NoSQL;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MongoTestExtendDao extends MongoTestDao {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;

    private String ExampleName;


    public MongoTestExtendDao(){
        super();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getExampleName() {
        return ExampleName;
    }

    public void setExampleName(String exampleName) {
        ExampleName = exampleName;
        super.setName("Name od dziecka");
    }
}
