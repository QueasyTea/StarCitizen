package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.5f;

    private Texture img;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;



    @Override
    public void show() {
        super.show();
        img = new Texture("front.jpg");
        pos = new Vector2();
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        tmp.set(touch);
        if(touch.cpy().sub(pos).len() > v.len()){
            pos.add(v);
        } else {
            pos.set(touch);
        }
        Gdx.gl.glClearColor(0.5f, 0.23f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x,pos.y);
        batch.end();

    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);


        v.set(touch.cpy().sub(pos)).setLength(V_LEN);


        return false;
    }
}
