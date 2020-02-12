package com.kamil.serwis.dao.SQL;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class TestDB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer testId;

    private String name;


    public TestDB() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

}
