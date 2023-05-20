package com.blockpage.gameservice.adaptor.web.controller;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import com.blockpage.gameservice.adaptor.web.apispec.APIResponse;
import com.blockpage.gameservice.adaptor.web.view.GameView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
@Slf4j
public class GameController {

    @GetMapping
    public ResponseEntity<APIResponse> getGame() {
        GameView gameView = new GameView(2, 2);
        return ResponseEntity.ok().body(new APIResponse(gameView));
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateGame(@RequestParam("type") String type) {
        switch (type) {
            case "rullet": {
                GameEntity gameEntity = GameEntity.builder()
                    .lottoDayCount(3)
                    .rulletDayCount(2)
                    .build();
                return ResponseEntity.ok().body(new APIResponse("룰렛 게임을 실행하였습니다", gameEntity.getRulletDayCount()));
            }
            case "lotto": {
                GameEntity gameEntity = GameEntity.builder()
                    .lottoDayCount(2)
                    .rulletDayCount(3)
                    .build();
                return ResponseEntity.ok().body(new APIResponse("복권 게임을 실행하였습니다", gameEntity.getLottoDayCount()));
            }
            default: {
                return ResponseEntity.ok().body(new APIResponse("이벤트 실행해보세요"));
            }
        }
    }
}
