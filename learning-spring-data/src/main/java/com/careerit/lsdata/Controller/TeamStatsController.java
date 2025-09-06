package com.careerit.lsdata.Controller;

import com.careerit.lsdata.dto.TeamStats;
import com.careerit.lsdata.service.TeamStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-stats")
@RequiredArgsConstructor
public class TeamStatsController {

    private final TeamStatsService teamStatsService;

    @GetMapping("/{teamLabel}")
    public TeamStats getTeamStats(@PathVariable String teamLabel) {
        return teamStatsService.getTeamStats(teamLabel);
    }

    @GetMapping
    public List<TeamStats> getAllTeamStats() {
        return teamStatsService.getAllTeamStats();
    }
}

