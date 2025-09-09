package com.careerit.lsdata.dao;

import com.careerit.lsdata.domain.PlayerDetails;
import com.careerit.lsdata.domain.TeamDetails;
import com.careerit.lsdata.dto.PlayerDto;
import com.careerit.lsdata.dto.TeamStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IplStatsDao {


        Page<PlayerDetails> getAllPlayerDetails(Pageable pageable, String searchTerm);
        Page<TeamDetails> getAllTeamDetails(Pageable pageable, String searchTerm);

        List<TeamStats> getAllTeamStats();
        List<PlayerDto> getTopFivePaidPlayers();

}
