package com.careerit.lsdata.service;

import com.careerit.lsdata.dao.IplStatsDao;
import com.careerit.lsdata.dto.TeamStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamStatsService {

    private final IplStatsDao teamStatsDao;

    public TeamStats getTeamStats(String teamLabel) {
        return teamStatsDao.getTeamStats(teamLabel);
    }

    public List<TeamStats> getAllTeamStats() {
        return teamStatsDao.getAllTeamStats();
    }
}
