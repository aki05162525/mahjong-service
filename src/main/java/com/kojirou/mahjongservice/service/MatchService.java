package com.kojirou.mahjongservice.service;

import com.kojirou.mahjongservice.entity.League;
import com.kojirou.mahjongservice.entity.Match;
import com.kojirou.mahjongservice.repository.LeagueRepository;
import com.kojirou.mahjongservice.repository.MatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class MatchService {

    private final MatchRepository matchRepo;
    private final LeagueRepository leagueRepo;

    public MatchService(MatchRepository matchRepo, LeagueRepository leagueRepo) {
        this.matchRepo = matchRepo;
        this.leagueRepo = leagueRepo;
    }

    /** リーグ内の全試合取得 */
    public List<Match> findByLeague(UUID leagueId) {
        return matchRepo.findByLeagueId(leagueId);
    }

    /** ID で試合取得 */
    public Match findById(UUID id) {
        return matchRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found"));
    }

    /** 試合作成 */
    public Match create(UUID leagueId, Match m) {
        League league = leagueRepo.findById(leagueId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "League not found"));
        m.setLeague(league);
        return matchRepo.save(m);
    }

    /** 試合更新 */
    public Match update(UUID id, Match updated) {
        Match existing = findById(id);
        existing.setMatchNumber(updated.getMatchNumber());
        existing.setRuleType(updated.getRuleType());
        return matchRepo.save(existing);
    }

    /** 試合削除 */
    public void delete(UUID id) {
        findById(id);
        matchRepo.deleteById(id);
    }
}
