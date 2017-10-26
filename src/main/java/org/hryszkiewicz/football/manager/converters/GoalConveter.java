package org.hryszkiewicz.football.manager.converters;

import org.hryszkiewicz.football.manager.model.Goal;
import org.springframework.beans.BeanUtils;

/**
 * Created by Marek on 22.10.2017.
 */
public class GoalConveter {

    public static Goal createModel(final GoalEntity goalEntity) {
        final Goal goal = new Goal();
//        goal.setScorer(goalEntity.getScorer().getFirstName() + " ");
        BeanUtils.copyProperties(goalEntity, goal);

        return goal;
    }

    public static GoalEntity createEntity(final Goal goal) {
        final GoalEntity goalEntity = new GoalEntity();
        BeanUtils.copyProperties(goal, goalEntity);

        return goalEntity;
    }
}
