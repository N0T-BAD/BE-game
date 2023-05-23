package com.blockpage.gameservice.adaptor.infrastructure.persistance;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import com.blockpage.gameservice.adaptor.infrastructure.repository.GameRepository;
import com.blockpage.gameservice.application.port.out.GamePort;
import com.blockpage.gameservice.domain.Game;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameAdaptor implements GamePort {

    private final GameRepository gameRepository;

    @Override
    public Game getGame(Game game) {
        Optional<GameEntity> gameEntity = gameRepository.findByMemberEmailAndRegisterTimeAfter(game.getMemberEmail(),
            LocalDate.now().minusDays(1).atTime(11, 59, 59));
        if (gameEntity.isPresent()) {
            return Game.fromGameEntity(gameEntity.get());
        } else {
            GameEntity postGame = GameEntity.postGame(game);
            gameRepository.save(postGame);
            return Game.fromGameEntity(postGame);

        }
    }
}