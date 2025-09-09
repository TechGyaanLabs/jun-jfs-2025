package com.careerit.lsdata;

import com.careerit.lsdata.dao.IplStatsDao;
import com.careerit.lsdata.domain.PlayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class LearningSpringDataApplication implements CommandLineRunner {

    @Autowired
    private IplStatsDao iplStatsDao;

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringDataApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

       /* Pageable pageable = PageRequest.of(0, 10);
        Page<PlayerDetails> playerDetailsPage = iplStatsDao.getAllPlayerDetails(pageable,"");
        playerDetailsPage.getContent().forEach(ele-> System.out.println(ele.getTeam()));

        System.out.println(playerDetailsPage.getTotalElements());
        System.out.println(playerDetailsPage.getTotalPages());
        System.out.println(playerDetailsPage.getNumber());
        System.out.println(playerDetailsPage.getSize());
        System.out.println(playerDetailsPage.getSort());*/

        System.out.println(iplStatsDao.getAllTeamStats());

    }
}
