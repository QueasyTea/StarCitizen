package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.5f;

    private Texture img;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;
    private Logo logo;



    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
        logo = new Logo(img);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();


    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        logo.touchDown(touch,pointer,button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);


        v.set(touch.cpy().sub(pos)).setLength(V_LEN);


        return false;
    }

    private void update(float delta){
        logo.update(delta);
    }



    private void draw(){
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
        logo.draw(batch);
        batch.end();
    }
}
