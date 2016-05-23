package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.progress.ProgressTexture;

public class Progress {

    private View view;
    private Mastership mastership;

    private int currentFrame;
    private long time;

    private boolean done;
    private boolean firstDone;

    public Progress(ProgressTexture progressTexture, Star currentStar, Mastership mastership) {

        view = new View(progressTexture, currentStar.getModel().getCenterPoint(), 0);

        this.mastership = mastership;
    }

    private void update() {

        view.update(false);

        if (view.getCurrentFrame() == (view.getTexturesPack().getTextures().size - 1) && firstDone) {
            done = true;
            firstDone = false;
        } else {
            done = false;
            if (currentFrame != (view.getTexturesPack().getTextures().size - 1))
                firstDone = true;
        }
    }

    public int getLength() {
        return view.getTexturesPack().getTextures().size;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public boolean isDone() {
        return done;
    }

}
