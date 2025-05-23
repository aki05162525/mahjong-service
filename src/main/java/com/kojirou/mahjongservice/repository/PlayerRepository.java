package com.kojirou.mahjongservice.repository;

import com.kojirou.mahjongservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
