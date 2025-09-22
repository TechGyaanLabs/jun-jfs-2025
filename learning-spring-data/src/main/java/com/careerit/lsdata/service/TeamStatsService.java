package com.careerit.lsdata.service;

import com.careerit.lsdata.dto.TeamStats;
import com.careerit.lsdata.repo.TeamDetailsRepo;
import com.careerit.lsdata.repo.impl.TeamStatsJooqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStatsService {

    @Autowired
    private TeamDetailsRepo teamDetailsRepo;

    @Autowired
    private TeamStatsJooqRepository teamStatsJooqRepository;

    // Using JPA/JPQL
    public List<TeamStats> getTeamStatsWithJpa() {
        return null;
    }

    // Using JOOQ
    public List<TeamStats> getTeamStatsWithJooq() {
        return null;
    }
}


