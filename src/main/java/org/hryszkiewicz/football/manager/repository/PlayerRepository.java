package org.hryszkiewicz.football.manager.repository;

import org.hryszkiewicz.football.manager.persistence.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    PlayerEntity findByPlayerIdIgnoreCase(final String playerId);

    List<PlayerEntity> findAll();

    List<PlayerEntity> findByClubId(final Long clubId);

}
