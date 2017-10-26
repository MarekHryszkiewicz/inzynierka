package org.hryszkiewicz.football.manager.rest.controller.service;

import org.hryszkiewicz.football.manager.converters.ClubConverter;
import org.hryszkiewicz.football.manager.converters.PlayerConverter;
import org.hryszkiewicz.football.manager.model.Club;
import org.hryszkiewicz.football.manager.model.Player;
import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.hryszkiewicz.football.manager.persistence.PlayerEntity;
import org.hryszkiewicz.football.manager.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marek on 12.10.2017.
 */

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Transactional
    public Club addClub(final ClubEntity clubEntity) {

        clubRepository.save(clubEntity);
        // LOGGER.info("Player added.");

        return ClubConverter.createModel(clubEntity);
    }

    @Transactional
    public List<Club> getClubs() {
        List<ClubEntity> clubEntities = clubRepository.findAll();
        List<Club> clubs = new ArrayList<>(clubEntities.size());
        for (ClubEntity clubEntity : clubEntities) {
            final Club club = ClubConverter.createModel(clubEntity);
            clubs.add(club);
        }
        return clubs;
    }

    @Transactional
    public Club getClubById(final String clubId) {
        final ClubEntity clubEntity = clubRepository.findByClubIdIgnoreCase(clubId);

        return ClubConverter.createModel(clubEntity);
    }
}
