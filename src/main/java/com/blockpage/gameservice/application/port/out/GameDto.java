package com.blockpage.gameservice.application.port.out;

import com.blockpage.gameservice.domain.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GameDto {

    private Integer rouletteDayCount;

    private Integer lottoDayCount;

    private Boolean compensation;

    public GameDto(Boolean compensation) {
        this.compensation = compensation;
    }

    public static GameDto fromGame(Game game) {
        return GameDto.builder()
            .rouletteDayCount(game.getRouletteDayCount())
            .lottoDayCount(game.getLottoDayCount())
            .build();
    }

}