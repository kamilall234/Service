package com.kamil.serwis.service.User;

import com.kamil.serwis.model.SQL.User;
import com.kamil.serwis.repository.dao.SQL.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.transaction.TransactionManager;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(transactionManager = "entityManagerFactoryMySQL")
    @PostConstruct
    public void createUser(){
        User newUser = new User("test");
        User usersaved = userRepository.addUserToDB(newUser);
    }
}
