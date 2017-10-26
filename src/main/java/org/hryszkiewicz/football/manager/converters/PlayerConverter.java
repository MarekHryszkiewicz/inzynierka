package org.hryszkiewicz.football.manager.converters;

import org.hryszkiewicz.football.manager.model.Player;
import org.hryszkiewicz.football.manager.persistence.PlayerEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by Marek on 24.08.2017.
 */
public class PlayerConverter {

    public static Player createModel(final PlayerEntity playerEntity){
        final Player player = new Player();
        BeanUtils.copyProperties(playerEntity, player);
        player.setClubId(playerEntity.getClub().getClubId());
        if (playerEntity.getGoals()!=null){
            player.setGoals(playerEntity.getGoals().size());

        }
        if (playerEntity.getAssist()!=null){
            player.setAssists(playerEntity.getAssist().size());
        }

        return player;
    }

    public static PlayerEntity createEntity(final Player player){
        final PlayerEntity playerEntity = new PlayerEntity();
        BeanUtils.copyProperties(player, playerEntity);
        
        return playerEntity;
    }
}
