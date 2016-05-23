package com.mygdx.game.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.LineTextures;

public class Line {

    private Star star;

    private View view;

    private TexturesPack none;
    private TexturesPack friendly;
    private TexturesPack hostile;

    public Line(Star star, Point destinationStar) {

        this.star = star;

        none = new LineTextures(getLineTexture(star, Constants.Colors.none, destinationStar));
        friendly = new LineTextures(getLineTexture(star, Constants.Colors.friendly, destinationStar));
        hostile = new LineTextures(getLineTexture(star, Constants.Colors.hostile, destinationStar));

        view = new View(none, star.getModel().getCenterPoint(), 0);

        updateSide();
    }

    public static Texture getLineTexture(Star star, Color color, Point destinationStar) {

        Pixmap pixmap = new Pixmap(
                (int) (Math.max(star.getModel().getCenterPoint().getX(), destinationStar.getX()) -
                        Math.min(star.getModel().getCenterPoint().getX(), destinationStar.getX())),

                (int) (Math.max(star.getModel().getCenterPoint().getY(), destinationStar.getY()) -
                        Math.min(star.getModel().getCenterPoint().getY(), destinationStar.getY())),

                Pixmap.Format.RGBA8888);

        pixmap.setColor(color);
        pixmap.drawLine((int) star.getModel().getCenterPoint().getX(), (int) star.getModel().getCenterPoint().getY(),
                (int) destinationStar.getX() / 2, (int) destinationStar.getY() / 2);

        Texture line = new Texture(pixmap);

        pixmap.dispose();
        return line;
    }

    public void updateSide() {
        switch (star.getModel().getSide()) {
            case Constants.Sides.NONE:
                view.setTexturesPack(none);
                break;
            case Constants.Sides.FRIENDLY:
                view.setTexturesPack(friendly);
                break;
            case Constants.Sides.HOSTILE:
                view.setTexturesPack(hostile);
                break;
        }
    }

    public View getView() {
        return view;
    }

    public void dispose() {
        for (Texture texture : none.getTextures())
            texture.dispose();

        for (Texture texture : friendly.getTextures())
            texture.dispose();

        for (Texture texture : hostile.getTextures())
            texture.dispose();
    }
}
