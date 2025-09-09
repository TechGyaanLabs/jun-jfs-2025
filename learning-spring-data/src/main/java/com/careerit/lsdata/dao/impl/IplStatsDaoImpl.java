package com.careerit.lsdata.dao.impl;

import com.careerit.lsdata.dao.IplStatsDao;
import com.careerit.lsdata.dto.TeamStats;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;



public class IplStatsDaoImpl implements IplStatsDao {
    @Override
    public TeamStats getTeamStats(String teamLabel) {
        return null;
    }

    @Override
    public List<TeamStats> getAllTeamStats() {
        return null;
    }
}
