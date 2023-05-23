package com.blockpage.gameservice.domain;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Game {

    private String memberEmail;

    private Integer rouletteDayCount;

    private Integer lottoDayCount;

    public Game(String memberEmail) {
        this.memberEmail= memberEmail;
    }

    public static Game fromGameEntity(GameEntity gameEntity) {
        return Game.builder()
            .rouletteDayCount(gameEntity.getRouletteDayCount())
            .lottoDayCount(gameEntity.getLottoDayCount())
            .build();
    }

}