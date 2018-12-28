package com.mygdx.game.actions;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.system.Constants;

// проверка конца игры
public class GameEnd {

    public static int isGameEnd(Array<Star> stars) {

        int controlledStarsFriendly = 0;
        int controlledStarsHostile = 0;

        synchronized (stars) {
            for (Star star : stars)
                if (star.getBasicStar().getModel().getSide() == Constants.Sides.FRIENDLY)
                    controlledStarsFriendly++;
                else if (star.getBasicStar().getModel().getSide() == Constants.Sides.HOSTILE)
                    controlledStarsHostile++;

            if (controlledStarsFriendly / (float) stars.size > 0.66)
                return Constants.Sides.FRIENDLY;
            if (controlledStarsHostile / (float) stars.size > 0.66)
                return Constants.Sides.HOSTILE;

            return 0;
        }
    }

}
