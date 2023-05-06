package com.blockpage.gameservice.adaptor.web.controller;

import com.blockpage.gameservice.adaptor.web.apispec.APIResponse;
import com.blockpage.gameservice.adaptor.web.view.GameView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
@Slf4j
public class GameController {

    @GetMapping
    public ResponseEntity<APIResponse> getGame() {
        GameView gameView = new GameView(2, 2, true);
        return ResponseEntity.ok().body(new APIResponse(gameView));
    }
}
