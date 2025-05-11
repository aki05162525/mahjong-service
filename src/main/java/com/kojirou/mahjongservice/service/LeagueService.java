package com.kojirou.mahjongservice.service;

import com.kojirou.mahjongservice.entity.League;
import com.kojirou.mahjongservice.repository.LeagueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class LeagueService {

    private final LeagueRepository repo;

    public LeagueService(LeagueRepository repo) {
        this.repo = repo;
    }

    public List<League> findAll() {
        return repo.findAll();
    }

    public League findById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "League not found"));
    }

    public League create(League league) {
        return repo.save(league);
    }

    public League update(UUID id, League updated) {
        League exist = findById(id);
        exist.setName(updated.getName());
        return repo.save(exist);
    }

    public void delete(UUID id) {
        findById(id);
        repo.deleteById(id);
    }
}
