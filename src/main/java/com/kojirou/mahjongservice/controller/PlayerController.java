// src/main/java/com/kojirou/mahjongservice/controller/PlayerController.java
package com.kojirou.mahjongservice.controller;

import com.kojirou.mahjongservice.entity.Player;
import com.kojirou.mahjongservice.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    /** 全プレイヤー取得 */
    @GetMapping
    public List<Player> getAll() {
        return service.findAll();
    }

    /** 単一プレイヤー取得 */
    @GetMapping("/{id}")
    public Player getOne(@PathVariable UUID id) {
        return service.findById(id);
    }

    /** プレイヤー作成 */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player create(@RequestBody Player player) {
        return service.create(player);
    }

    /** プレイヤー更新 */
    @PutMapping("/{id}")
    public Player update(
            @PathVariable UUID id,
            @RequestBody Player player
    ) {
        return service.update(id, player);
    }

    /** プレイヤー削除 */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
