package com.kojirou.mahjongservice.controller;

import com.kojirou.mahjongservice.entity.League;
import com.kojirou.mahjongservice.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/leagues")
public class LeagueController {

    private final LeagueService service;

    public LeagueController(LeagueService service) {
        this.service = service;
    }

    @GetMapping
    public List<League> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public League get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public League create(@RequestBody League league) {
        return service.create(league);
    }

    @PutMapping("/{id}")
    public League update(@PathVariable UUID id, @RequestBody League league) {
        return service.update(id, league);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
