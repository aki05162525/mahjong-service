package com.kojirou.mahjongservice.repository;

import com.kojirou.mahjongservice.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeagueRepository extends JpaRepository<League, UUID> {
}
