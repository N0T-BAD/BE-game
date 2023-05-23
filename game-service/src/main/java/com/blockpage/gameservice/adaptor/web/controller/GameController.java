package com.blockpage.gameservice.adaptor.web.controller;

import com.blockpage.gameservice.adaptor.web.view.ApiResponse;
import com.blockpage.gameservice.adaptor.web.view.GameView;
import com.blockpage.gameservice.application.port.in.GameUseCase;
import com.blockpage.gameservice.application.port.in.GameUseCase.GetQuery;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
@Slf4j
public class GameController {

    private final GameUseCase gameUseCase;

    @GetMapping
    public ResponseEntity<ApiResponse<GameView>> getGame(HttpSession session) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ApiResponse<>(new GameView(gameUseCase.getGameQuery(new GetQuery(session)))));
    }

//    @PutMapping
//    public ResponseEntity<ApiResponse> updateGame(@RequestBody RequestGame requestGame, HttpSession session) {
//        //TODO  게임실행,보상로직 구현 및 블럭서비스 연결필요
//
//        switch (type) {
//            case "rullet": {
//                GameEntity gameEntity = GameEntity.builder()
//                    .lottoDayCount(3)
//                    .rouletteDayCount(2)
//                    .build();
//                return ResponseEntity.ok().body(new ApiResponse(new GameView("룰렛게임을 실행했습니다.")));
//            }
//            case "lotto": {
//                GameEntity gameEntity = GameEntity.builder()
//                    .lottoDayCount(2)
//                    .rouletteDayCount(3)
//                    .build();
//                return ResponseEntity.ok().body(new ApiResponse(new GameView("복권게임을 실행했습니다.")));
//            }
//            default: {
//                return ResponseEntity.ok().body(new ApiResponse("이벤트 실행해보세요"));
//            }
//        }
//    }
}

