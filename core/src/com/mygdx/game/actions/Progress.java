package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.progress.ProgressTexture;

public class Progress {

    private View view;

    private boolean done;
    private boolean firstDone;

    private Point centerPoint;

    private TexturesPack texturesPack;

    public Progress(TexturesPack texturesPack, Point centerPoint) {

        this.centerPoint = centerPoint;
        this.texturesPack = texturesPack;

        view = new View(texturesPack, centerPoint, 0);
    }

    private void update() {

        view.setRenderPointByCenter(centerPoint);
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

    public void setCenterPoint(Point centerPoint){
        view.setRenderPointByCenter(centerPoint);
        this.centerPoint = centerPoint;
    }

    public TexturesPack getTexturesPack() {
        return texturesPack;
    }

    public void setTexturesPack(TexturesPack texturesPack) {
        this.texturesPack = texturesPack;
    }
}
