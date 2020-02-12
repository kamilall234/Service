package com.kamil.serwis.dao.SQL;

import javax.persistence.*;

@Entity
public class TestDBExtend extends TestDB{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer testId;

    private String nameChildren;

    public TestDBExtend() {
        super();

    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getNameChildren() {
        return nameChildren;
    }

    public void setNameChildren(String nameChildren) {
        this.nameChildren = nameChildren;
        super.setName(new StringBuffer().toString().toUpperCase().concat("fromChildren"));
    }
    @ManyToOne
    private TestDBOneToMany testDBoneToMany;

    public void setTestDBoneToMany(TestDBOneToMany testDBoneToMany) {
        this.testDBoneToMany = testDBoneToMany;
    }
}
