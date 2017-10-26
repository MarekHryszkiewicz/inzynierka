package org.hryszkiewicz.football.manager.rest.controller.service;

import org.hryszkiewicz.football.manager.converters.GoalConveter;
import org.hryszkiewicz.football.manager.converters.PlayerConverter;
import org.hryszkiewicz.football.manager.exceptions.GeneralException;
import org.hryszkiewicz.football.manager.model.Goal;
import org.hryszkiewicz.football.manager.model.Player;
import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.hryszkiewicz.football.manager.persistence.PlayerEntity;
import org.hryszkiewicz.football.manager.repository.ClubRepository;
import org.hryszkiewicz.football.manager.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Marek on 20.08.2017.
 */
@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClubRepository clubRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    @Transactional
    public Player addPlayer(final Player player) {
        final PlayerEntity playerEntity = PlayerConverter.createEntity(player);
        final ClubEntity clubEntity = clubRepository.findByClubIdIgnoreCase(player.getClubId());
        if(clubEntity==null){
            throw new GeneralException("test");
        }
        playerEntity.setClub(clubEntity);
        playerRepository.save(playerEntity);
        LOGGER.info("Player added.");

        return PlayerConverter.createModel(playerEntity);
    }

    @Transactional
    public List<Player> getPlayers() {
        List<PlayerEntity> list = playerRepository.findAll();
        List<Player> modelList = new ArrayList<>();
        for (PlayerEntity player : list) {
            System.out.println("CLUB: " + player.getClub().getName());
            modelList.add(PlayerConverter.createModel(player));
        }
        return modelList;
    }

    @Transactional
    public Player getPlayerById(final String playerId) throws Exception {
        if (StringUtils.isEmpty(playerId)) {
            throw new Exception("PlayerId is mandatory!");
        }
        return PlayerConverter.createModel(playerRepository.findByPlayerIdIgnoreCase(playerId));
    }

    @Transactional
    public PlayerEntity updatePlayer(final String playerId, final Player player) throws Exception {

        final PlayerEntity playerEntity = playerRepository.findByPlayerIdIgnoreCase(playerId);

        if(playerEntity==null){
            throw new Exception("Player does not exists!");
        }

        if (!playerId.equals(player.getPlayerId())){
            throw new Exception("PlayerId is not equalt to playerId in json!");
        }

        playerEntity.setFirstName(player.getFirstName());
        playerEntity.setLastName(player.getLastName());
        final ClubEntity clubEntity = clubRepository.findByClubIdIgnoreCase(player.getClubId());
        if(clubEntity==null){
            throw new GeneralException("test");
        }
        playerEntity.setClub(clubEntity);
        return playerRepository.save(playerEntity);
    }

    @Transactional
    public List<Player> getPlayersByClubId(final String clubId) {
        List<PlayerEntity> list = playerRepository.findAll();
        List<Player> modelList = new ArrayList<>();
        for (PlayerEntity player : list) {
            System.out.println("PRZED");
            if(player.getClub().getClubId().equals(clubId)) {
                System.out.println("CLUB: " + player.getClub().getName());
                modelList.add(PlayerConverter.createModel(player));
            }
        }
        return modelList;
    }

    @Transactional
    public Goal addGoalToPlayer(final Goal goal, final String playerId){
        final PlayerEntity playerEntity = playerRepository.findByPlayerIdIgnoreCase(playerId);
        playerEntity.getGoals().add(GoalConveter.createEntity(goal));
        playerRepository.save(playerEntity);

        return goal;
    }
}
