package org.hryszkiewicz.football.manager.rest.controller.controller.player;

import io.swagger.annotations.*;
import org.hryszkiewicz.football.manager.model.Goal;
import org.hryszkiewicz.football.manager.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marek on 21.08.2017.
 */
@Api("Player api")
@RestController
@RequestMapping("/players")
public interface PlayerController {

    @ApiOperation(value = "Add player",
            notes = "Add player",
            tags = {"player"})
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Player> addPlayer(@ApiParam(value = "Player", required = true) @RequestBody @Valid Player player) throws Exception;

    @ApiOperation(value = "Update player.",
            notes = "Update player.",
            tags = {"player"})
    @RequestMapping(path = "/{playerId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<Player> updatePlayer(@ApiParam(value = "playerId", required = true) @PathVariable("playerId") final String playerId, @RequestBody @Valid  Player player) throws Exception;

    @ApiOperation(value = "Get all players",
            notes = "Get all  players",
            tags = {"player"})
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Player>> getPlayers() throws Exception;

    @ApiOperation(value = "Get player by id",
            notes = "Get player by id",
            tags = {"player"})
    @RequestMapping(path = "/{playerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Player>> getPlayerById(@ApiParam(value = "playerId", required = true) @PathVariable("playerId") final String playerId) throws Exception;


    @ApiOperation(value = "Get player by clubId",
            notes = "Get player by clubId",
            tags = {"player"})
    @RequestMapping(path = "/club/{clubId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Player>> getPlayerByClubId(@ApiParam(value = "clubId", required = true) @PathVariable("clubId") final String clubId) throws Exception;

    @ApiOperation(value = "Add goal to player.",
            notes = "Add goal to player.",
            tags = {"player"})
    @RequestMapping(path = "/{playerId}/goal",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<Goal> addGoalToPlayer(@ApiParam(value = "playerId", required = true) @PathVariable("playerId") final String playerId, @RequestBody @Valid Goal goal) throws Exception;



}
