package com.blockpage.gameservice.application.service;

import com.blockpage.gameservice.application.port.in.GameUseCase;
import com.blockpage.gameservice.application.port.out.GameDto;
import com.blockpage.gameservice.application.port.out.GamePort;
import com.blockpage.gameservice.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService implements GameUseCase {

    private final GamePort gamePort;

    @Override
    public void postGameQuery(PostQuery postQuery) {
        gamePort.postGame(new Game(postQuery.getMemberId()));
    }

    @Override
    public GameDto getGameQuery(GetQuery getQuery) {
        return GameDto.fromGame(gamePort.getGame(new Game(getQuery.getMemberId())));
    }
}