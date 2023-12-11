package com.oop.Screen;

import com.badlogic.gdx.Screen;
import com.oop.Box2DTutorial;

public class LoadingScreen implements Screen {

    private Box2DTutorial parent;
    public LoadingScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(Box2DTutorial.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
