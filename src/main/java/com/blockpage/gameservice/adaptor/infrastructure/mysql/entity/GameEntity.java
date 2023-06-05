package com.blockpage.gameservice.adaptor.infrastructure.mysql.entity;

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
    private String memberEmail;

    @Column
    private Integer rouletteDayCount;

    @Column
    private Integer lottoDayCount;

    public static GameEntity postGame(Game game) {
        return GameEntity.builder()
            .memberEmail(game.getMemberEmail())
            .rouletteDayCount(3)
            .lottoDayCount(3)
            .build();
    }

    //룰렛실행시 횟수 감소
    public void setRouletteDayCount(Integer rouletteDayCount) {
        this.rouletteDayCount = rouletteDayCount;
    }

    //로또 실행시 횟수 감소
    public void setLottoDayCount(Integer lottoDayCount) {
        this.lottoDayCount = lottoDayCount;
    }
}