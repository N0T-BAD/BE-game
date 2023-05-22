package com.blockpage.gameservice.adaptor.web.controller;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import com.blockpage.gameservice.adaptor.web.view.ApiResponse;
import com.blockpage.gameservice.adaptor.web.view.GameView;
import com.blockpage.gameservice.application.port.in.GameUseCase;
import com.blockpage.gameservice.application.port.in.GameUseCase.GetQuery;
import com.blockpage.gameservice.application.port.in.GameUseCase.PostQuery;
import com.blockpage.gameservice.application.port.in.RequestGame;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
@Slf4j
public class GameController {

    private final GameUseCase gameUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<GameView>> postGame(@RequestBody RequestGame requestGame) {
        gameUseCase.postGameQuery(new PostQuery(requestGame.getMemberId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(new GameView("게임이 생성되었습니다.")));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<GameView>> getGame(@RequestBody RequestGame requestGame) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ApiResponse<>(new GameView(gameUseCase.getGameQuery(new GetQuery(requestGame.getMemberId())))));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateGame(@RequestParam("type") String type) {
        //TODO  게임실행,보상로직 구현 및 블럭서비스 연결필요
        switch (type) {
            case "rullet": {
                GameEntity gameEntity = GameEntity.builder()
                    .lottoDayCount(3)
                    .rouletteDayCount(2)
                    .build();
                return ResponseEntity.ok().body(new ApiResponse(new GameView("룰렛게임을 실행했습니다.")));
            }
            case "lotto": {
                GameEntity gameEntity = GameEntity.builder()
                    .lottoDayCount(2)
                    .rouletteDayCount(3)
                    .build();
                return ResponseEntity.ok().body(new ApiResponse(new GameView("복권게임을 실행했습니다.")));
            }
            default: {
                return ResponseEntity.ok().body(new ApiResponse("이벤트 실행해보세요"));
            }
        }
    }
}
