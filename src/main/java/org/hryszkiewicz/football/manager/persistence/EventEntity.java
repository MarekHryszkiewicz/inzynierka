package org.hryszkiewicz.football.manager.persistence;

import org.hryszkiewicz.football.manager.model.constant.EventEnum;

import java.io.Serializable;

/**
 * Created by Marek on 23.10.2017.
 */
public class EventEntity implements Serializable {

    private EventEnum event;

    private PlayerEntity scorer;

    private MatchEntity match;

    private PlayerEntity assistent;


}
