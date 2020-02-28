package com.kamil.serwis.model.SQL.test;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestDBOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer testId;

    private String oneToManyName;

    public Integer getTestId() {
        return testId;
    }

    public String getOneToManyName() {
        return oneToManyName;
    }

    public void setOneToManyName(String oneToManyName) {
        this.oneToManyName = oneToManyName;
    }

    @OneToMany(mappedBy = "testDBoneToMany")
    private List<TestDBExtend> testDBExtends = new ArrayList<>();

    public List<TestDBExtend> getTestDBExtends() {
        return testDBExtends;
    }

    public void setTestDBExtends(TestDBExtend testDBExtends) {
        this.testDBExtends.add(testDBExtends);
    }
}
