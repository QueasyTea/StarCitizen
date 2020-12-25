package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class GameOver extends Sprite {

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(0.05f);
        setHeightProportion(0.05f);
    }
}
