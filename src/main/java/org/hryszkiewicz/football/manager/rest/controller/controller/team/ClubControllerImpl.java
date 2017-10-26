package org.hryszkiewicz.football.manager.rest.controller.controller.team;

import org.hryszkiewicz.football.manager.converters.ClubConverter;
import org.hryszkiewicz.football.manager.model.Club;
import org.hryszkiewicz.football.manager.model.Player;
import org.hryszkiewicz.football.manager.rest.controller.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marek on 12.10.2017.
 */
@RestController
@RequestMapping("/clubs")
public class ClubControllerImpl implements ClubController {

    @Autowired
    ClubService clubService;

    @Override
    public ResponseEntity<Club> addClub(Club club) throws Exception {
        return new ResponseEntity<>(clubService.addClub(ClubConverter.createEntity(club)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Club>> getClubs() throws Exception {
        return new ResponseEntity<>(clubService.getClubs(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Club> getClubById(final String clubId) throws Exception {
        return new ResponseEntity<>(clubService.getClubById(clubId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Player>> updatePlayer() throws Exception {
        return null;
    }
}
