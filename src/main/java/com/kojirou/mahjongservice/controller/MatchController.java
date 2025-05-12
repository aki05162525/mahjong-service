package com.kojirou.mahjongservice.controller;

import com.kojirou.mahjongservice.entity.Match;
import com.kojirou.mahjongservice.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/leagues/{leagueId}/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping
    public List<Match> listByLeague(@PathVariable UUID leagueId) {
        return service.findByLeague(leagueId);
    }

    @GetMapping("/{id}")
    public Match get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Match create(
            @PathVariable UUID leagueId,
            @RequestBody Match match
    ) {
        return service.create(leagueId, match);
    }

    @PutMapping("/{id}")
    public Match update(
            @PathVariable UUID id,
            @RequestBody Match match
    ) {
        return service.update(id, match);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
