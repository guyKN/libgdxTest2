package com.mygdx.game2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class testGame extends ApplicationAdapter {

	private Texture rainDropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;

	private Rectangle bucket;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		rainDropImage = new Texture(Gdx.files.internal("sprites/drop.png"));
		bucketImage = new Texture(Gdx.files.internal("sprites/bucket.png"));

		dropSound = Gdx.audio.newSound(Gdx.files.internal("sound/drop-sound.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/rain-sound.mp3"));
		rainMusic.setLooping(true);

		bucket = new Rectangle();
		bucket.x = 800/2-4/2;
		bucket.y=20;
		bucket.width=64;
		bucket.height=4;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800,480);
		batch = new SpriteBatch();
		rainMusic.play();

	}

	@Override
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.end();
	}

}