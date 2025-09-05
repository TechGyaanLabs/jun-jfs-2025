package com.careerit.lsdata;

import com.careerit.lsdata.repo.PlayerDetailsRepo;
import com.careerit.lsdata.repo.TeamDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringDataApplication implements CommandLineRunner {


    @Autowired
    private TeamDetailsRepo teamDetailsRepo;

    @Autowired
    private PlayerDetailsRepo playerDetailsRepo;

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringDataApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
