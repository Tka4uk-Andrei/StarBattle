package com.mygdx.game.gameObjects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;

public class Line {

    private Star star;

    private View view;

    private Texture none;
    private Texture friendly;
    private Texture hostile;

    public Line(Star star, Point destinationStar) {

        none = getLineTexture(star, destinationStar);
        friendly = getLineTexture(star, destinationStar);
        hostile = getLineTexture(star, destinationStar);

    }

    public static Texture getLineTexture(Star star, Point destinationStar) {

        Pixmap pixmap = new Pixmap(
                (int) (Math.max(star.getModel().getCenterPoint().getX(), destinationStar.getX()) -
                        Math.min(star.getModel().getCenterPoint().getX(), destinationStar.getX())),

                (int) (Math.max(star.getModel().getCenterPoint().getY(), destinationStar.getY()) -
                        Math.min(star.getModel().getCenterPoint().getY(), destinationStar.getY())),

                Pixmap.Format.RGBA8888);

        pixmap.setColor(Constants.Colors.none);
        pixmap.drawLine((int) star.getModel().getCenterPoint().getX(), (int) star.getModel().getCenterPoint().getY(),
                (int) destinationStar.getX() / 2, (int) destinationStar.getY() / 2);

        Texture line = new Texture(pixmap);

        pixmap.dispose();
        return line;
    }

    public View getView() {
        return view;
    };
}
