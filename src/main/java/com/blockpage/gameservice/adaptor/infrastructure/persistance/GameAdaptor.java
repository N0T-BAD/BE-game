package com.blockpage.gameservice.adaptor.infrastructure.persistance;

import static com.blockpage.gameservice.exception.ErrorCode.GAME_BAD_REQUEST;
import static com.blockpage.gameservice.exception.ErrorCode.GAME_UNAVAILABLE;

import com.blockpage.gameservice.adaptor.infrastructure.entity.GameEntity;
import com.blockpage.gameservice.adaptor.infrastructure.repository.GameRepository;
import com.blockpage.gameservice.application.port.out.GamePort;
import com.blockpage.gameservice.domain.Game;
import com.blockpage.gameservice.exception.CustomException;
import java.time.LocalDate;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameAdaptor implements GamePort {

    private final GameRepository gameRepository;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void playGame(Game game) {
        GameEntity gameEntity = gameRepository.findByMemberEmailAndRegisterTimeAfter(game.getMemberEmail(),
            LocalDate.now().minusDays(1).atTime(11, 59, 59)).get();
        if (game.getType().equals("roulette") && gameEntity.getRouletteDayCount() > 0) {
            gameEntity.setRouletteDayCount(gameEntity.getRouletteDayCount() - 1);
            gameRepository.save(gameEntity);
        } else if (game.getType().equals("lotto") && gameEntity.getLottoDayCount() > 0) {
            gameEntity.setLottoDayCount(gameEntity.getLottoDayCount() - 1);
            gameRepository.save(gameEntity);
        } else if (game.getType().equals("roulette") || game.getType().equals("lotto")) {
            throw new CustomException(GAME_UNAVAILABLE.getMessage(), GAME_UNAVAILABLE.getHttpStatus());
        } else {
            throw new CustomException(GAME_BAD_REQUEST.getMessage(), GAME_BAD_REQUEST.getHttpStatus());
        }
    }
}