package com.blockpage.gameservice.adaptor.infrastructure.entity;

import com.blockpage.gameservice.domain.Game;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game")
public class GameEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long memberId;

    @Column
    private Integer rouletteDayCount;

    @Column
    private Integer lottoDayCount;

    public static GameEntity postGame(Game game) {
        return GameEntity.builder()
            .memberId(game.getMemberId())
            .rouletteDayCount(3)
            .lottoDayCount(3)
            .build();
    }

}