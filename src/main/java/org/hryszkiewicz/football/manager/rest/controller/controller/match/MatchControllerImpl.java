package org.hryszkiewicz.football.manager.rest.controller.controller.match;

import org.hryszkiewicz.football.manager.model.Match;
import org.hryszkiewicz.football.manager.model.Player;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Marek on 21.10.2017.
 */
public class MatchControllerImpl implements MatchController {
    @Override
    public ResponseEntity<List<Match>> getMatchs() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Match>> getMatchById(String matchId) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Player>> updateMatch() throws Exception {
        return null;
    }
}
