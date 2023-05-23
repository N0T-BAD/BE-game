package com.blockpage.gameservice.application.port.out;

import com.blockpage.gameservice.domain.Game;

public interface GamePort {

    Game getGame(Game game);

    void playGame(Game game);
}