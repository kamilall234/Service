package com.kamil.serwis.repository;

import com.kamil.serwis.dao.NoSQL.MongoTestDao;
import com.kamil.serwis.dao.NoSQL.MongoTestExtendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;


@Repository
public class MongoTest {


    //TODO How connect to right entityManagerMongo?
    @PersistenceContext(unitName ="MongoDBPersistence")
    private EntityManager entityManagerMongo;

    @Transactional(transactionManager = "mongoTransactionManager")
    public void addTestEntityToMongoDB(){

        MongoTestDao testDBmongo = new MongoTestDao();
        System.out.println("Entity Manager z MongoRepository " +entityManagerMongo.toString());
        testDBmongo.setName("TestMongoDB");
        MongoTestExtendDao mongoTestExtendDao = new MongoTestExtendDao();
        mongoTestExtendDao.setExampleName("TEST dziedziczenia do bazy");
        try {
            entityManagerMongo.persist(testDBmongo);
            entityManagerMongo.persist(mongoTestExtendDao);
            entityManagerMongo.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        /*Optional<MongoTestExtendDao>*/ MongoTestExtendDao mongoTestExtendDaoOptional = entityManagerMongo.find(MongoTestExtendDao.class, new String("50b50bc7-483f-4b7c-ac01-5852f1b64cb5"));

        System.out.println("Pobranie z bazy danych "+mongoTestExtendDaoOptional.getExampleName());
        MongoTestDao mongoTestDaoFromExtendDao = (MongoTestDao) mongoTestExtendDaoOptional;
        System.out.println("Pobrane z bazy, test rodzica"+mongoTestDaoFromExtendDao.getName());
    }
}
