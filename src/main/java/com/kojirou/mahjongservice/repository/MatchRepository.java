package com.kojirou.mahjongservice.repository;

import com.kojirou.mahjongservice.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
    List<Match> findByLeagueId(UUID leagueId);
}
