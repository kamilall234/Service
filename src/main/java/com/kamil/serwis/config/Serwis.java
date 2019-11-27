package com.kamil.serwis.config;

import com.kamil.serwis.config.RepoTest;
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
