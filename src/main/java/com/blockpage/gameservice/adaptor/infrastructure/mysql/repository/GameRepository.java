package com.blockpage.gameservice.adaptor.infrastructure.mysql.repository;

import com.blockpage.gameservice.adaptor.infrastructure.mysql.entity.GameEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {

    Optional<GameEntity> findByMemberEmailAndRegisterTimeAfter(String memberEmail, LocalDateTime today);

}