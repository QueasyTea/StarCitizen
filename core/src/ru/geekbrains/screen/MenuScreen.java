package ru.geekbrains.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.ButtonExit;
import ru.geekbrains.sprite.ButtonPlay;
import ru.geekbrains.sprite.Star;


public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 256;

    private Texture bg;
    private Background background;

    private TextureAtlas atlas;
    private Star[] stars;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    private final Game game;

    public MenuScreen(Game game) {
        this.game = game;
    }


    private Music music;


    @Override
    public void show() {
        super.show();
        bg = new Texture("android/assets/front.jpg");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/menuAtlas");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++){
            stars[i] = new Star(atlas);
        }
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);
        music = Gdx.audio.newMusic(Gdx.files.internal("android/sounds/music.mp3"));
        music.setLooping(true);
        music.play();




    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        music.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }

        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch,pointer,button);
        buttonPlay.touchDown(touch,pointer,button);

        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch,pointer,button);
        buttonPlay.touchUp(touch,pointer,button);

        return false;
    }

    private void update(float delta) {
        for (Star star : stars){
            star.update(delta);
        }


    }

    private void draw() {
        Gdx.gl.glClearColor(0.55f, 0.23f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);

        batch.end();

    }
}
