package org.hryszkiewicz.football.manager.rest.controller.controller.player;

import org.hryszkiewicz.football.manager.converters.PlayerConverter;
import org.hryszkiewicz.football.manager.model.Goal;
import org.hryszkiewicz.football.manager.model.Player;
import org.hryszkiewicz.football.manager.rest.controller.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marek on 24.08.2017.
 */
@RestController
@RequestMapping("/players")
public class PlayerControllerImpl implements PlayerController {

    @Autowired
    PlayerService playerService;

    @Override
    public ResponseEntity<Player> addPlayer(@RequestBody @Valid final Player player) throws Exception {

        final Player newPlayer = playerService.addPlayer(player);

        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Player>> getPlayers() throws Exception {
        return new ResponseEntity<>(playerService.getPlayers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Player>> getPlayerById(final String playerId) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Player> updatePlayer( final String playerId, @RequestBody @Valid Player player) throws Exception {
        return new ResponseEntity<>(PlayerConverter.createModel(playerService.updatePlayer(playerId, player)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Player>> getPlayerByClubId(String clubId) throws Exception {
        return new ResponseEntity<>(playerService.getPlayersByClubId(clubId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Goal> addGoalToPlayer(String playerId, @RequestBody @Valid Goal goal) throws Exception {
        return new ResponseEntity<Goal>(playerService.addGoalToPlayer(goal, playerId), HttpStatus.OK);
    }
}
