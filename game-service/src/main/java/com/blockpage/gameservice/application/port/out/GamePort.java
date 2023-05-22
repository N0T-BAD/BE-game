package com.blockpage.gameservice.application.port.out;

import com.blockpage.gameservice.domain.Game;

public interface GamePort {

    void postGame(Game game);

    Game getGame(Game game);
}