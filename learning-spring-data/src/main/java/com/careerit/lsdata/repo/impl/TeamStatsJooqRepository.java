package com.careerit.lsdata.repo.impl;

import com.careerit.lsdata.domain.TeamDetails;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TeamStatsJooqRepository {

    @Autowired
    private DSLContext dslContext;

    public TeamDetails getTeamDetails(UUID id) {
        return null;
    }
}
