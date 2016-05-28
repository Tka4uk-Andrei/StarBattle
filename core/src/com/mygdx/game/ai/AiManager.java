package com.mygdx.game.ai;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actions.GameEnd;
import com.mygdx.game.gameObjects.ships.mastership.FriendlyMastership;
import com.mygdx.game.gameObjects.ships.mastership.HostileMasterShip;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.Constants;

public class AiManager extends Thread {

    private Array<Star> stars;
    private HostileMasterShip hostileMastership;
    private FriendlyMastership friendlyMastership;
    private float starPeriodicity[];
    private int endFlag = 0;

    public AiManager(Array<Star> stars, HostileMasterShip hostileMastership, FriendlyMastership friendlyMastership) {

        this.stars = stars;
        this.hostileMastership = hostileMastership;
        this.friendlyMastership = friendlyMastership;

        starPeriodicity = new float[stars.size];
        for (int i = 0; i < starPeriodicity.length; ++i)
            starPeriodicity[i] = 0;
    }

    @Override
    public void run() {
        super.run();

        synchronized (stars){
            endFlag = GameEnd.isGameEnd(stars);
        }
        while (endFlag == 0) {

            for (int i = 0; i < starPeriodicity.length; ++i)
                starPeriodicity[i] = 0;

            int max = 0;

            synchronized (hostileMastership.getStar()) {
                if (hostileMastership.getStar().getBasicStar().getModel().getSide() == Constants.Sides.HOSTILE && !hostileMastership.getSend().isSande()) {
                    for (int i = 0; i < hostileMastership.getStar().getBasicStar().getModel().getConnectedStars().length; ++i) {
                        synchronized (stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i])) {
                            if (!friendlyMastership.getModel().getCenterPoint().
                                    equals(stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).getBasicStar().getModel().getCenterPoint())
                                    && (!stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).isBlocked(Constants.Sides.FRIENDLY) ||
                                    stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).getBasicStar().getModel().getSide() != Constants.Sides.FRIENDLY)) {

                                switch (stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).getBasicStar().getModel().getSide()) {
                                    case Constants.Sides.NONE:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 4;
                                        break;

                                    case Constants.Sides.FRIENDLY:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 2;
                                        break;

                                    case Constants.Sides.HOSTILE:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 0;
                                        break;
                                }

                                starPeriodicity[
                                        hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]
                                        ] += stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).getBasicStar().getModel().getConnectedStars().length;

                                switch (stars.get(hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]).getBasicStar().getModel().getType()) {
                                    case StarModel.Constants.Types.SMALL:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 1;
                                        break;
                                    case StarModel.Constants.Types.FACTORY:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 2;
                                        break;
                                    case StarModel.Constants.Types.MINE:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 2;
                                        break;
                                    case StarModel.Constants.Types.ADVANCED_FACTORY:
                                        starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]] += 2;
                                        break;
                                }

                                if (starPeriodicity[max] < starPeriodicity[hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i]])
                                    max = hostileMastership.getStar().getBasicStar().getModel().getConnectedStars()[i];
                            }
                        }
                    }
                    synchronized (stars.get(max)) {
                        hostileMastership.send(stars.get(max));
                    }
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
