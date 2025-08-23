package com.careerit.jfs.cj.iplstatsusingdb.dao;

import com.careerit.jfs.cj.iplstatsusingdb.domain.Player;
import com.careerit.jfs.cj.iplstatsusingdb.dto.AboveAveragePlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatsDaoImpl implements PlayerStatsDao {

    @Override
    public List<TeamStatsDto> getTeamStatistics() {
        String sql = """
            SELECT team,
                   MAX(price) AS max_price,
                   MIN(price) AS min_price,
                   COUNT(*)   AS count,
                   ROUND(AVG(price),2) AS avg_price,
                   SUM(price) AS total_amount
            FROM players
            GROUP BY team
            ORDER BY team
        """;
        List<TeamStatsDto> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TeamStatsDto dto = TeamStatsDto.builder()
                        .team(rs.getString("team"))
                        .maxPrice(rs.getDouble("max_price"))
                        .minPrice(rs.getDouble("min_price"))
                        .count(rs.getLong("count"))
                        .avgPrice(rs.getDouble("avg_price"))
                        .totalAmount(rs.getDouble("total_amount"))
                        .build();
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching team stats", e);
        }
        return list;
    }

    @Override
    public List<TopPlayerDto> getTop5HighestAmountPaidPlayers() {
        String sql = """
            SELECT id, name, role, country, team, price
            FROM players
            ORDER BY price DESC
            LIMIT 5
        """;
        List<TopPlayerDto> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            int rank = 1;
            while (rs.next()) {
                TopPlayerDto dto = TopPlayerDto.builder()
                        .id((java.util.UUID) rs.getObject("id"))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .country(rs.getString("country"))
                        .team(rs.getString("team"))
                        .price(rs.getDouble("price"))
                        .rank(rank++)
                        .build();
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching top 5 players", e);
        }
        return list;
    }

    @Override
    public List<TopPlayerDto> getTop2HighestAmountPaidPlayersEachTeam() {
        String sql = """
            SELECT id, name, role, country, team, price, rnk
            FROM (
                SELECT id, name, role, country, team, price,
                       ROW_NUMBER() OVER (PARTITION BY team ORDER BY price DESC) as rnk
                FROM players
            ) t
            WHERE rnk <= 2
        """;
        List<TopPlayerDto> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TopPlayerDto dto = TopPlayerDto.builder()
                        .id((java.util.UUID) rs.getObject("id"))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .country(rs.getString("country"))
                        .team(rs.getString("team"))
                        .price(rs.getDouble("price"))
                        .rank(rs.getInt("rnk"))
                        .build();
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching top 2 players each team", e);
        }
        return list;
    }

    @Override
    public List<AboveAveragePlayerDto> getPlayersAboveTeamAverage() {
        String sql = """
            SELECT p.id, p.name, p.role, p.country, p.team, p.price,
                   t.avg_price AS team_average_price,
                   (p.price - t.avg_price) AS difference_from_average
            FROM players p
            JOIN (
                SELECT team, AVG(price) AS avg_price
                FROM players
                GROUP BY team
            ) t ON p.team = t.team
            WHERE p.price > t.avg_price
            ORDER BY p.team, p.price DESC
        """;
        List<AboveAveragePlayerDto> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AboveAveragePlayerDto dto = AboveAveragePlayerDto.builder()
                        .id((java.util.UUID) rs.getObject("id"))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .country(rs.getString("country"))
                        .team(rs.getString("team"))
                        .price(rs.getDouble("price"))
                        .teamAveragePrice(rs.getDouble("team_average_price"))
                        .differenceFromAverage(rs.getDouble("difference_from_average"))
                        .build();
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching players above avg", e);
        }
        return list;
    }

    @Override
    public List<Player> getPlayersByCountry(String country) {
        String sql = "SELECT * FROM players WHERE country = ?";
        List<Player> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, country);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Player player = Player.builder()
                            .id((java.util.UUID) rs.getObject("id"))
                            .name(rs.getString("name"))
                            .role(rs.getString("role"))
                            .country(rs.getString("country"))
                            .team(rs.getString("team"))
                            .price(rs.getDouble("price"))
                            .build();
                    list.add(player);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching players by country", e);
        }
        return list;
    }
}
