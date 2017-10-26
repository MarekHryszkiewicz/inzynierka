package org.hryszkiewicz.football.manager.repository;

import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.hryszkiewicz.football.manager.persistence.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Marek on 26.10.2017.
 */
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    EventEntity findByNameIgnoreCase(final String name);

    ClubEntity findByClubIdIgnoreCase(final String clubId);

    List<EventEntity> findAll();
}