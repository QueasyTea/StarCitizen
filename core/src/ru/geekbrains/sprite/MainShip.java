package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MainShip extends Sprite {

    private static final float HEIGHT = 0.15f;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("mainShip"), 1, 2, 2);
    }


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }
}
