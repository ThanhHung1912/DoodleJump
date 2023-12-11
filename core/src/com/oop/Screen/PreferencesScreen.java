package com.oop.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oop.Box2DTutorial;
import com.oop.Screen.Preferences.*;
import com.badlogic.gdx.Preferences;

public class PreferencesScreen implements Screen {
    private Box2DTutorial parent;
    private Stage stage;

    // Labels
    private Label titleLabel;
    private Label musicVolumeLabel;
    private Label soundVolumeLabel;
    private Label musicBoxLabel;
    private Label soundBoxLabel;

    public PreferencesScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;

        // Add a stage
        stage = new Stage(new ScreenViewport());
    }
    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);


        // Create Buttons for preferences
        Skin skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));

        // music volume
        final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
        volumeMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
                // updateVolumeLabel();
                return false;
            }
        });

        // sound volume
        final Slider soundMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        soundMusicSlider.setValue(parent.getPreferences().getSoundVolume());
        soundMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setSoundVolume(soundMusicSlider.getValue());
                // updateVolumeLabel();
                return false;
            }
        });

        // music on/off
        final CheckBox musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked(parent.getPreferences().isMusicEnabled());
        musicCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = musicCheckbox.isChecked();
                parent.getPreferences().setMusicEnabled(enabled);
                return false;
            }
        });

        final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
        soundEffectsCheckbox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
        soundEffectsCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = soundEffectsCheckbox.isChecked();
                parent.getPreferences().setSoundEffectsEnabled(enabled);
                return false;
            }
        });

        // return to main screen button
        final TextButton backButton = new TextButton("Back", skin, "small");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Box2DTutorial.MENU);
            }
        });

        titleLabel = new Label("Preferences", skin);
        musicVolumeLabel = new Label("Music Volume", skin);
        soundVolumeLabel = new Label("Sound Volume", skin);
        musicBoxLabel = new Label("Music", skin);
        soundBoxLabel = new Label("Sound",skin);

        table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
        table.add(musicVolumeLabel);
        table.add(volumeMusicSlider);
        table.row().pad(10,0,0,10);
        table.add(musicBoxLabel).left();
        table.add(musicCheckbox);
        table.row().pad(10,0,0,10);
        table.add(soundVolumeLabel);
        table.add(soundMusicSlider);
        table.row().pad(10,0,0,10);
        table.add(soundBoxLabel).left();
        table.add(soundEffectsCheckbox);
        table.row().pad(10,0,0,10);
        table.add(backButton).colspan(2);


    }

    @Override
    public void render(float delta) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

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
