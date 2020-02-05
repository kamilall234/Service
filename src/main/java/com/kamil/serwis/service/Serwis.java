package com.kamil.serwis.service;
import com.kamil.serwis.repository.MongoTest;
import com.kamil.serwis.repository.RepoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;


@Service
public class Serwis {

    @Autowired
    RepoTest repoTest;

    @Autowired
    MongoTest mongoTest;


    public Serwis() {

    }

    @PostConstruct
    public void addEntityToDB(){
        repoTest.addTestEntity();
    }


    @PostConstruct
    public void addEntityTestToMongoDB(){
        mongoTest.addTestEntityToMongoDB();
    }

}
