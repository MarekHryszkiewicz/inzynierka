package org.hryszkiewicz.football.manager.rest.controller.controller.team;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hryszkiewicz.football.manager.model.Club;
import org.hryszkiewicz.football.manager.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Club api")
@RestController
@RequestMapping("/clubs")
public interface ClubController {

    @ApiOperation(value = "Add club",
            notes = "Add club",
            tags = {"club"})
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Club> addClub(/*@ApiParam(value = "Player", required = true)*/ @RequestBody @Valid Club club) throws Exception;

    @ApiOperation(value = "Get all teams",
            notes = "Get all  teams",
            tags = {"club"})
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<List<Club>> getClubs() throws Exception;

    @ApiOperation(value = "Get team by id",
            notes = "Get team by id",
            tags = {"club"})
    @RequestMapping(path = "/{teamId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<Club> getClubById(@ApiParam(value = "clubId", required = true) @PathVariable("clubId") final String clubId) throws Exception;

    @ApiOperation(value = "Update player.",
            notes = "Update team.",
            tags = {"club"})
    @RequestMapping(path = "/{teamId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Player>> updatePlayer() throws Exception;

}
