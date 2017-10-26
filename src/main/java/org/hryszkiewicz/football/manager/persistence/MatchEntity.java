package org.hryszkiewicz.football.manager.persistence;


import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class MatchEntity implements Serializable{

    private StadiumEntity stadium;

    private ZonedDateTime date;

    private ClubEntity homeTeam;

    private ClubEntity awayTeam;

    private List<GoalEntity> homeTeamGoals;

    private List<GoalEntity> awayTeamGoals;

    private SquadEntity homeSquad;

    private SquadEntity awaySquad;

    private List<CardEntity> homeCards;

    private List<CardEntity> awayCards;

}
