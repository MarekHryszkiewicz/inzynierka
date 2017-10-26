package org.hryszkiewicz.football.manager.model;


import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.hryszkiewicz.football.manager.persistence.PlayerEntity;

import java.io.Serializable;

public class Goal implements Serializable {

    private PlayerEntity scorer;

    private PlayerEntity assistent;

    private ClubEntity opponent;


    public PlayerEntity getScorer() {
        return scorer;
    }

    public void setScorer(PlayerEntity scorer) {
        this.scorer = scorer;
    }

    public PlayerEntity getAssistent() {
        return assistent;
    }

    public void setAssistent(PlayerEntity assistent) {
        this.assistent = assistent;
    }

    public ClubEntity getOpponent() {
        return opponent;
    }

    public void setOpponent(ClubEntity opponent) {
        this.opponent = opponent;
    }
}
