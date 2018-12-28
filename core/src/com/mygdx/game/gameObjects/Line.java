package com.mygdx.game.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.gameObjects.stars.BasicStar;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.LineTextures;

// линия между звёздами
public class Line {

    private BasicStar star;

    private View view;

    private TexturesPack none;
    private TexturesPack friendly;
    private TexturesPack hostile;

    public Line(BasicStar star, Point destinationStar) {

        this.star = star;

        none = new LineTextures(getLineTexture(star, Constants.Colors.none, destinationStar));
        friendly = new LineTextures(getLineTexture(star, Constants.Colors.friendly, destinationStar));
        hostile = new LineTextures(getLineTexture(star, Constants.Colors.hostile, destinationStar));

        view = new View(none, new Point(
                star.getModel().getCenterPoint().getX()
                        + (destinationStar.getX() - star.getModel().getCenterPoint().getX()) / 4,
                star.getModel().getCenterPoint().getY()
                        + (destinationStar.getY() - star.getModel().getCenterPoint().getY()) / 4), 0);

        updateSide();
    }

    public static Texture test(BasicStar star, Color color, Point destinationStar) {

        Pixmap pixmap = new Pixmap(50, 53, Pixmap.Format.RGBA8888);

        pixmap.setColor(color);


        pixmap.drawLine(1, 1, 5, 50);

        Texture line = new Texture(pixmap);

        pixmap.dispose();
        return line;
    }

    public static Texture getLineTexture(BasicStar star, Color color, Point destinationStar) {

        Pixmap pixmap = new Pixmap(
                (int) (Math.max(star.getModel().getCenterPoint().getX(), destinationStar.getX()) -
                        Math.min(star.getModel().getCenterPoint().getX(), destinationStar.getX())) / 2 + 1,

                (int) (Math.max(star.getModel().getCenterPoint().getY(), destinationStar.getY()) -
                        Math.min(star.getModel().getCenterPoint().getY(), destinationStar.getY())) / 2 + 1,

                Pixmap.Format.RGBA8888);

        pixmap.setColor(color);

        Point start = new Point();
        Point end = new Point();

        if (star.getModel().getCenterPoint().getX() < destinationStar.getX()) {
            start.setX(0);
            end.setX(pixmap.getWidth() - 1);
        } else {
            start.setX(pixmap.getWidth() - 1);
            end.setX(0);
        }

        if (star.getModel().getCenterPoint().getY() < destinationStar.getY()) {
            start.setY(pixmap.getHeight() - 1);
            end.setY(0);
        } else {
            start.setY(0);
            end.setY(pixmap.getHeight() - 1);
        }

        pixmap.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

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
