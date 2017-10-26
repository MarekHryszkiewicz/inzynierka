package org.hryszkiewicz.football.manager.rest.controller.controller.match;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hryszkiewicz.football.manager.model.Match;
import org.hryszkiewicz.football.manager.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marek on 21.10.2017.
 */
@Api("Player api")
@RestController
@RequestMapping("/match")
public interface MatchController {


    @ApiOperation(value = "Get all matches.",
            notes = "Get all matches.",
            tags = {"match"})
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Match>> getMatchs() throws Exception;

    @ApiOperation(value = "Get match by id",
            notes = "Get match by id",
            tags = {"match"})
    @RequestMapping(path = "/{matchId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Match>> getMatchById(@ApiParam(value = "matchId", required = true) @PathVariable("matchId") final String matchId) throws Exception;

    @ApiOperation(value = "Update match.",
            notes = "Update match.",
            tags = {"match"})
    @RequestMapping(path = "/{matchId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<List<Player>> updateMatch() throws Exception;

}
