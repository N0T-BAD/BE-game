package com.blockpage.gameservice.domain;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Game {

    private Long memberId;

    private Integer rouletteDayCount;

    private Integer lottoDayCount;

    public Game(Long memberId) {
        this.memberId = memberId;
    }

    public static Game fromGameEntity(GameEntity gameEntity) {
        return Game.builder()
            .rouletteDayCount(gameEntity.getRouletteDayCount())
            .lottoDayCount(gameEntity.getLottoDayCount())
            .build();
    }

}