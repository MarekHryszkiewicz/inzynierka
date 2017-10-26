package org.hryszkiewicz.football.manager.converters;

import org.hryszkiewicz.football.manager.model.Club;
import org.hryszkiewicz.football.manager.persistence.ClubEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by Marek on 12.10.2017.
 */
public class ClubConverter {

    public static Club createModel(final ClubEntity clubEntity) {
        final Club club = new Club();
        BeanUtils.copyProperties(clubEntity, club);

        return club;
    }

    public static ClubEntity createEntity(final Club club) {
        final ClubEntity clubEntity = new ClubEntity();
        BeanUtils.copyProperties(club, clubEntity);

        return clubEntity;
    }
}
