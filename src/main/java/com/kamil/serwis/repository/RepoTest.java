package com.kamil.serwis.repository;
import com.kamil.serwis.dao.SQL.TestDB;
import com.kamil.serwis.dao.SQL.TestDBExtend;
import com.kamil.serwis.dao.SQL.TestDBOneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;


@Repository
public class RepoTest {


    @PersistenceContext(name = "MySQLPersistence")
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void addTestEntity(){
        System.out.println(entityManager.isOpen()+" "+entityManager.toString()+" Transaction "+entityManager.isJoinedToTransaction()+" EMF: "+entityManager.getEntityManagerFactory().toString());
        TestDB testDB = new TestDB();
        testDB.setName("testowany");
        TestDBExtend testDBExtend = new TestDBExtend();
        testDBExtend.setNameChildren("Test tabeli w pochodnej klasie ");
        try {
            entityManager.persist(testDB);
            System.out.println("ID testowe :" +testDB.getTestId());
            entityManager.persist(testDBExtend);
            entityManager.flush();
            System.out.println("Entity Manager z MySQLRepository "+entityManager.toString());
            testDB.setName("przetestowany");

        }catch (Exception e){
            e.printStackTrace();
        }

        TestDBOneToMany testDBOneToMany = new TestDBOneToMany();
        testDBOneToMany.setOneToManyName("Test persist dla OneToMany");
        TestDBExtend testDBExtend1 = new TestDBExtend();
        testDBExtend1.setNameChildren("Many to One test persist");
        testDBExtend1.setTestDBoneToMany(testDBOneToMany);

        try {
            entityManager.persist(testDBOneToMany);
            entityManager.persist(testDBExtend1);
            entityManager.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
