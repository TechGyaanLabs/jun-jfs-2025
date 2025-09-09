package com.careerit.lsdata.dao.impl;

import com.careerit.lsdata.dao.IplStatsDao;
import com.careerit.lsdata.domain.PlayerDetails;
import com.careerit.lsdata.domain.TeamDetails;
import com.careerit.lsdata.dto.PlayerDto;
import com.careerit.lsdata.dto.TeamStats;
import com.careerit.lsdata.repo.PlayerDetailsRepo;
import com.careerit.lsdata.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IplStatsDaoImpl implements IplStatsDao {

    private final TeamDetailsRepo teamDetailsRepo;
    private final PlayerDetailsRepo playerDetailsRepo;

    @Override
    public Page<PlayerDetails> getAllPlayerDetails(Pageable pageable, String searchTerm) {
        if(StringUtils.hasText(searchTerm)){
            return playerDetailsRepo.findAll(pageable,searchTerm);
        }
        return playerDetailsRepo.findAll(pageable);
    }


    @Override
    public Page<TeamDetails> getAllTeamDetails(Pageable pageable, String searchTerm) {
            Page<TeamDetails> allTeamDetails = null;
            if(StringUtils.hasText(searchTerm)){
                allTeamDetails = teamDetailsRepo.getTeamDetailsWithSearchTerm(pageable, searchTerm);
            }else{
                allTeamDetails = teamDetailsRepo.findAll(pageable);
            }
            log.info("Total team size  is {} with search term {}", allTeamDetails, searchTerm);
            return allTeamDetails;
    }

    @Override
    public List<TeamStats> getAllTeamStats() {
        return null;
    }

    @Override
    public List<PlayerDto> getTopFivePaidPlayers() {
        return List.of();
    }
}
