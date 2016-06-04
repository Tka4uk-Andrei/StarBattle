package com.mygdx.game.system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.models.ViewModel;

public class View {

    private TexturesPack textures;
    private long time;

    private int currentFrame;

    private BitmapFont bitmapFont;
    private String text;

    private ViewModel viewModel;

    public View(TexturesPack texturesPack, Point centerPoint, Point originPoint, int currentFrame, float rotation) {

        time = System.currentTimeMillis();
        textures = texturesPack;
        this.currentFrame = currentFrame;

        Point renderPoint = new Point(
                centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth() / 2,
                centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight() / 2
        );

        viewModel = new ViewModel(renderPoint,
                new Point(
                        originPoint.getX() - renderPoint.getX(),
                        originPoint.getY() - renderPoint.getY()
                ), centerPoint, rotation);

        bitmapFont = null;
    }

    public View(TexturesPack texturesPack, Point centerPoint, int currentFrame) {
        time = System.currentTimeMillis();
        textures = texturesPack;
        this.currentFrame = currentFrame;

        Point renderPoint = new Point(
                centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth() / 2,
                centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight() / 2);

        Point originPoint = new Point(
                textures.getTextures().get(currentFrame).getWidth() / 2,
                textures.getTextures().get(currentFrame).getHeight() / 2);

        viewModel = new ViewModel(renderPoint, originPoint, centerPoint, 0);

        bitmapFont = null;
    }

    public View(BitmapFont bitmapFont, String text, Point centerPoint) {

        this.bitmapFont = bitmapFont;
        this.text = text;

        GlyphLayout layout = new GlyphLayout();
        layout.setText(bitmapFont, text);

        viewModel = new ViewModel(new Point(
                centerPoint.getX() - layout.width / 2,
                centerPoint.getY()
        ), new Point(), new Point(), 0);

        textures = null;
    }

    public void update(boolean rotationFlag) {
        if (textures == null)
            time = System.currentTimeMillis();
        if (System.currentTimeMillis() - time >= textures.getFrameTime()) {
            time = System.currentTimeMillis();
            currentFrame = (currentFrame + 1) % textures.getTextures().size;
            if (rotationFlag) {
                viewModel.setRotation(viewModel.getRotation() + textures.getDeltaDegree());
                if (viewModel.getRotation() >= 360)
                    viewModel.setRotation(viewModel.getRotation() - 360);
            }
        }
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public Texture getFrame() {
        if (textures != null)
            return textures.getTextures().get(currentFrame);
        else
            return null;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public TexturesPack getTexturesPack() {
        return textures;
    }

    public void setTexturesPack(TexturesPack textures) {
        if (textures == null)
            textures = this.textures;

        this.textures = textures;
    }

    public void setOriginPointInCenter() {
        viewModel.setOriginPoint(new Point(getTexturesPack().getTextures().get(0).getWidth() / 2,
                getTexturesPack().getTextures().get(0).getHeight() / 2));
    }

    public void setRenderPointByCenter(Point centerPoint) {
        viewModel.setCenterPoint(new Point(centerPoint));
        viewModel.getRenderPoint().setX(centerPoint.getX() - getTexturesPack().getTextures().get(0).getWidth() / 2);
        viewModel.getRenderPoint().setY(centerPoint.getY() - getTexturesPack().getTextures().get(0).getHeight() / 2);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public BitmapFont getBitmapFont() {
        return bitmapFont;
    }

    public void setBitmapFont(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
