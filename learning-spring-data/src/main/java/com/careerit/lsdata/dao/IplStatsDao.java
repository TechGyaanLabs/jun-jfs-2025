package com.careerit.lsdata.dao;

import com.careerit.lsdata.dto.TeamStats;

import java.util.List;

public interface IplStatsDao {

        TeamStats getTeamStats(String teamLabel);

        List<TeamStats> getAllTeamStats();

}
