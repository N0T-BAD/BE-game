package com.blockpage.gameservice.application.port.out;

import com.blockpage.gameservice.domain.Game;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameDto {

    private Integer rouletteDayCount;

    private Integer lottoDayCount;

    public static GameDto fromGame(Game game) {
        return GameDto.builder()
            .rouletteDayCount(game.getRouletteDayCount())
            .lottoDayCount(game.getLottoDayCount())
            .build();
    }
}