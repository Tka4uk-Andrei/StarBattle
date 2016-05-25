package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.progress.ProgressTexture;

public class Progress {

    private View view;

    private boolean done;
    private boolean firstDone;

    private Mastership mastership;

    public Progress(ProgressTexture progressTexture, Mastership mastership) {

        this.mastership = mastership;

        view = new View(progressTexture, mastership.getModel().getCenterPoint(), 0);
    }

    private void update() {

        view.setRenderPoint(mastership.getModel().getCenterPoint());
        view.update(false);

        if (view.getCurrentFrame() == (view.getTexturesPack().getTextures().size - 1) && firstDone) {
            done = true;
            firstDone = false;
        } else {
            done = false;
            if (view.getCurrentFrame() != (view.getTexturesPack().getTextures().size - 1))
                firstDone = true;
        }
    }

    public int getLength() {
        return view.getTexturesPack().getTextures().size;
    }

    public void setTime(long time) {
        view.setTime(time);
    }

    public int getCurrentFrame() {
        return view.getCurrentFrame();
    }

    public void setCurrentFrame(int currentFrame) {
        view.setCurrentFrame(currentFrame);
    }

    public boolean isDone() {
        update();
        return done;
    }

    public View getView() {

        update();
        return view;
    }

}
