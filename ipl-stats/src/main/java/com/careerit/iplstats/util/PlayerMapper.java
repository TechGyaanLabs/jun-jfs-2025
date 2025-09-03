package com.careerit.iplstats.util;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public PlayerDto toDto(Player player) {
        if (player == null) {
            return null;
        }
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .team(player.getTeam())
                .role(player.getRole())
                .country(player.getCountry())
                .amount(player.getAmount())
                .build();
    }

    public Player toEntity(PlayerDto playerDto) {
        if (playerDto == null) {
            return null;
        }
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setTeam(playerDto.getTeam());
        player.setRole(playerDto.getRole());
        player.setCountry(playerDto.getCountry());
        player.setAmount(playerDto.getAmount());
        return player;
    }

    public List<PlayerDto> toDtoList(List<Player> players) {
        if (players == null) {
            return List.of();
        }
        return players.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Player> toEntityList(List<PlayerDto> playerDtos) {
        if (playerDtos == null) {
            return List.of();
        }
        return playerDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
