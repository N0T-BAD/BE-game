package com.blockpage.gameservice.adaptor.web.controller;

import com.blockpage.gameservice.adaptor.web.view.ApiResponse;
import com.blockpage.gameservice.adaptor.web.view.GameView;
import com.blockpage.gameservice.application.port.in.GameUseCase;
import com.blockpage.gameservice.application.port.in.GameUseCase.GetQuery;
import com.blockpage.gameservice.application.port.in.GameUseCase.PlayQuery;
import com.blockpage.gameservice.application.port.in.RequestGame;
import com.blockpage.gameservice.application.port.out.GameDto;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game-service/v1/games")
@Slf4j
public class GameController {

    private final GameUseCase gameUseCase;

    @GetMapping
    public ResponseEntity<ApiResponse<GameView>> getGame(@RequestHeader String memberId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ApiResponse<>(new GameView(gameUseCase.getGameQuery(new GetQuery(memberId)))));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<GameView>> updateGame(@RequestBody RequestGame requestGame, @RequestHeader String memberId) {
        GameDto gameDto = gameUseCase.playGameQuery(PlayQuery.toQuery(requestGame, memberId));
        if (gameDto.getCompensation()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(new GameView("축하합니다. 블럭이 지급되었습니다.")));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(new GameView("꽝, 다음 기회에...")));
        }
    }
}

