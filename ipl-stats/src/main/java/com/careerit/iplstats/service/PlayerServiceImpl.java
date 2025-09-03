package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.repo.PlayerRepository;
import com.careerit.iplstats.util.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDto addPlayer(PlayerDto playerDto) {
        log.info("Adding new player: {}", playerDto.getName());
        Player player = playerMapper.toEntity(playerDto);
        Player savedPlayer = playerRepository.save(player);
        log.info("Player added successfully with ID: {}", savedPlayer.getId());
        return playerMapper.toDto(savedPlayer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> getAllPlayers() {
        log.info("Fetching all players");
        List<Player> players = playerRepository.findAll();
        log.info("Found {} players", players.size());
        return playerMapper.toDtoList(players);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlayerDto> getPlayerById(UUID id) {
        log.info("Fetching player by ID: {}", id);
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            log.info("Player found: {}", player.get().getName());
        } else {
            log.warn("Player not found with ID: {}", id);
        }
        return player.map(playerMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> getPlayersByTeam(String team) {
        log.info("Fetching players by team: {}", team);
        List<Player> players = playerRepository.findByTeam(team);
        log.info("Found {} players for team: {}", players.size(), team);
        return playerMapper.toDtoList(players);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> getPlayersByRole(String role) {
        log.info("Fetching players by role: {}", role);
        List<Player> players = playerRepository.findByRole(role);
        log.info("Found {} players for role: {}", players.size(), role);
        return playerMapper.toDtoList(players);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> getPlayersByCountry(String country) {
        log.info("Fetching players by country: {}", country);
        List<Player> players = playerRepository.findByCountry(country);
        log.info("Found {} players for country: {}", players.size(), country);
        return playerMapper.toDtoList(players);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        log.info("Updating player: {}", playerDto.getName());
        if (playerDto.getId() == null) {
            throw new IllegalArgumentException("Player ID cannot be null for update operation");
        }
        Player player = playerMapper.toEntity(playerDto);
        Player updatedPlayer = playerRepository.save(player);
        log.info("Player updated successfully: {}", updatedPlayer.getName());
        return playerMapper.toDto(updatedPlayer);
    }

    @Override
    public PlayerDto updatePlayerById(UUID id, PlayerDto playerDto) {
        log.info("Updating player by ID: {}", id);
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
        
        // Update fields from DTO
        existingPlayer.setName(playerDto.getName());
        existingPlayer.setTeam(playerDto.getTeam());
        existingPlayer.setRole(playerDto.getRole());
        existingPlayer.setCountry(playerDto.getCountry());
        existingPlayer.setAmount(playerDto.getAmount());
        
        Player updatedPlayer = playerRepository.save(existingPlayer);
        log.info("Player updated successfully: {}", updatedPlayer.getName());
        return playerMapper.toDto(updatedPlayer);
    }

    @Override
    public boolean deletePlayer(UUID id) {
        log.info("Deleting player by ID: {}", id);
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            log.info("Player deleted successfully with ID: {}", id);
            return true;
        } else {
            log.warn("Player not found with ID: {}", id);
            return false;
        }
    }

    @Override
    public boolean deletePlayer(PlayerDto playerDto) {
        log.info("Deleting player: {}", playerDto.getName());
        if (playerDto.getId() != null) {
            return deletePlayer(playerDto.getId());
        } else {
            log.warn("Cannot delete player without ID");
            return false;
        }
    }

    @Override
    public void deleteAllPlayers() {
        log.info("Deleting all players");
        long count = playerRepository.count();
        playerRepository.deleteAll();
        log.info("Deleted {} players", count);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> searchPlayers(String searchTerm) {
        log.info("Searching players with term: {}", searchTerm);
        List<Player> players = playerRepository.searchPlayers(searchTerm);
        log.info("Found {} players matching search term: {}", players.size(), searchTerm);
        return playerMapper.toDtoList(players);
    }

    @Override
    @Transactional(readOnly = true)
    public long getPlayerCount() {
        long count = playerRepository.count();
        log.info("Total player count: {}", count);
        return count;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllTeams() {
        log.info("Fetching all unique teams");
        List<String> teams = playerRepository.findDistinctTeams();
        log.info("Found {} unique teams", teams.size());
        return teams;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllRoles() {
        log.info("Fetching all unique roles");
        List<String> roles = playerRepository.findDistinctRoles();
        log.info("Found {} unique roles", roles.size());
        return roles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllCountries() {
        log.info("Fetching all unique countries");
        List<String> countries = playerRepository.findDistinctCountries();
        log.info("Found {} unique countries", countries.size());
        return countries;
    }
}
