package com.kamil.serwis.repository.dao.SQL;


import com.kamil.serwis.model.SQL.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepository {

    @PersistenceContext(name = "MySQLPersistence")
    @Autowired
    private EntityManager entityManager;


    public User addUserToDB(User newUser){
        entityManager.persist(newUser);
        return newUser;
    }

    public User findUserByName(String userName){
        User user = (User)entityManager.createQuery( "select u from User u").getResultStream().findFirst().get();
        return user;
    }

    public boolean deleteUser(User userToDelete){
        entityManager.remove(userToDelete);
        return entityManager.find(User.class,userToDelete.getId()).equals(userToDelete);
    }
}
