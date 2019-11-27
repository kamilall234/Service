package com.kamil.serwis.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class RepoTest {

/*    @PersistenceUnit(name = "entityManagerFactoryUnit")
    @Qualifier(value = "entityManagerFactory")
    private EntityManagerFactory emf;*/

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(transactionManager = "transactionManager")
    public void addTestEntity(){
        System.out.println(entityManager.isOpen()+" "+entityManager.toString()+" Transaction "+entityManager.isJoinedToTransaction()+" EMF: "+entityManager.getEntityManagerFactory().toString());
        TestDB testDB = new TestDB();
        testDB.setName("testowany");
        try {
            entityManager.persist(testDB);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
