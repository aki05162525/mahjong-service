package com.kojirou.mahjongservice.service;

import com.kojirou.mahjongservice.entity.Player;
import com.kojirou.mahjongservice.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@Service
public class PlayerService {

    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    /** 全取得 */
    public List<Player> findAll() {
        return repo.findAll();
    }

    /** 単一取得（存在しなければ 404） */
    public Player findById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
    }

    /** 作成 */
    public Player create(Player p) {
        // id と createdAt は自動設定されるので、リクエストボディには name のみを含めて OK
        return repo.save(p);
    }

    /** 更新 */
    public Player update(UUID id, Player updated) {
        Player existing = findById(id);
        existing.setName(updated.getName());
        return repo.save(existing);
    }

    /** 削除 */
    public void delete(UUID id) {
        // 存在チェックを兼ねて findById を呼んでも良い
        repo.deleteById(id);
    }
}
