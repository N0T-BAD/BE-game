package com.blockpage.gameservice.adaptor.web.view;

import com.blockpage.gameservice.application.port.out.GameDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameView {

    private String message;

    private Integer rouletteDayCount;

    private Integer lottoDayCount;

    public GameView(String message) {
        this.message = message;
    }

    public GameView(GameDto gameDto) {
        this.rouletteDayCount = gameDto.getRouletteDayCount();
        this.lottoDayCount = gameDto.getLottoDayCount();
    }

    public GameView(String message, GameDto gameDto) {
        this.message = message;
        this.lottoDayCount = gameDto.getLottoDayCount();
        this.rouletteDayCount = gameDto.getRouletteDayCount();
    }
}
