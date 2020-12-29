package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.BaseButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class ButtonNewGame extends BaseButton {

    private GameScreen screen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen screen) {
        super(atlas.findRegion("new_game"));
        this.screen = screen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(-0.04f);
        setHeightProportion(0.06f);
    }

    @Override
    public void action() {
        screen.startNewGame();
    }
}