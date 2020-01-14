package com.kamil.serwis.repository;
import com.kamil.serwis.dao.TestDB;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
            System.out.println("ID testowe :" +testDB.getTestId());
            entityManager.flush();
            testDB.setName("przetestowany");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
