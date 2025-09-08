package com.careerit.lsdata.dao.impl;

import com.careerit.lsdata.dao.IplStatsDao;
import com.careerit.lsdata.dto.TeamStats;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class IplStatsDaoImpl implements IplStatsDao {

    private final DSLContext dsl;
    @Override
    public TeamStats getTeamStats(String teamLabel) {
        return dsl.select(
                        team_details.team_label,
                        team_details.team_name,
                        count(player_details.ID).as("totalPlayers"),
                        sum(player_details.AMOUNT).as("totalAmount"),
                        max(player_details.AMOUNT).as("maxAmount"),
                        min(player_details.AMOUNT).as("minAmount"),
                        avg(player_details.AMOUNT).as("averageAmount")
                )
                .from(TEAM_DETAILS)
                .leftJoin(PLAYER_DETAILS).on(TEAM_DETAILS.ID.eq(PLAYER_DETAILS.TEAM_ID))
                .where(TEAM_DETAILS.TEAM_LABEL.eq(teamLabel))
                .groupBy(TEAM_DETAILS.TEAM_LABEL, TEAM_DETAILS.TEAM_NAME)
                .fetchOneInto(TeamStats.class);
    }

    @Override
    public List<TeamStats> getAllTeamStats() {
        return dsl.select(
                        TEAM_DETAILS.TEAM_LABEL,
                        TEAM_DETAILS.TEAM_NAME,
                        count(PLAYER_DETAILS.ID).as("totalPlayers"),
                        sum(PLAYER_DETAILS.AMOUNT).as("totalAmount"),
                        max(PLAYER_DETAILS.AMOUNT).as("maxAmount"),
                        min(PLAYER_DETAILS.AMOUNT).as("minAmount"),
                        avg(PLAYER_DETAILS.AMOUNT).as("averageAmount")
                )
                .from(TEAM_DETAILS)
                .leftJoin(PLAYER_DETAILS).on(TEAM_DETAILS.ID.eq(PLAYER_DETAILS.TEAM_ID))
                .groupBy(TEAM_DETAILS.TEAM_LABEL, TEAM_DETAILS.TEAM_NAME)
                .fetchInto(TeamStats.class);
    }
}
