package com.blockpage.gameservice.application.service;

import com.blockpage.gameservice.adaptor.infrastructure.external.block.requestbody.RequestBlock;
import com.blockpage.gameservice.application.port.in.GameUseCase;
import com.blockpage.gameservice.application.port.out.BlockPort;
import com.blockpage.gameservice.application.port.out.GameDto;
import com.blockpage.gameservice.application.port.out.GamePort;
import com.blockpage.gameservice.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService implements GameUseCase {

    private final GamePort gamePort;
    private final BlockPort blockPort;

    @Override
    public GameDto getGameQuery(GetQuery getQuery) {
        return GameDto.fromGame(gamePort.getGame(new Game(getQuery.getMemberEmail())));
    }

    @Override
    public GameDto playGameQuery(PlayQuery playQuery) {
        gamePort.playGame(Game.playGame(playQuery));
        if(playQuery.getCompensation()){
            blockPort.postBlock(new RequestBlock(playQuery.getMemberEmail()));
        }
        return new GameDto(playQuery.getCompensation());
    }
}