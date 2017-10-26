package org.hryszkiewicz.football.manager.repository;

import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Marek on 18.10.2017.
 */
public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

        ClubEntity findByNameIgnoreCase(final String name);

        ClubEntity findByClubIdIgnoreCase(final String clubId);

        List<ClubEntity> findAll();
}
