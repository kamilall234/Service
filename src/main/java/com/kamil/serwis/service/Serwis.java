package com.kamil.serwis.service;
import com.kamil.serwis.repository.RepoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;


@Service
public class Serwis {

    @Autowired
    RepoTest repoTest;


    public Serwis() {

    }
    @Transactional
    @PostConstruct
    public void addEntityToDB(){
        repoTest.addTestEntity();
    }

}
