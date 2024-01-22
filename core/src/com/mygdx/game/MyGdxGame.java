package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;

import java.security.Key;
import java.util.ArrayList;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class MyGdxGame extends ApplicationAdapter {
	private float elapsedTime = 0;
	private float elapsedTime1 = 0;
	private int odcinek =0;
	public static SpriteBatch batch;
	public static boolean Zapis;
	Obiekty obj;

	static Texture tmp;

	static boolean posiada_klocek;
	TextureRegion textureRegion;
	Mapa mapa;
	Music music;

	@Override
	public void create() {
		music = Gdx.audio.newMusic(Gdx.files.internal("tetris.wav")); // Podaj nazwę swojego pliku

		music.setLooping(true);
		music.setVolume(0.5f);

		music.play();
		batch = new SpriteBatch();

		obj = new Obiekty();


		tmp = new Texture("tmp.png");
		posiada_klocek = true;
		obj.Losowanie();

		 textureRegion = new TextureRegion(obj.getTekstura(),obj.X_Region,obj.Y_Region, obj.szerokosc, obj.wysokosc);
		mapa = new Mapa();

	}

	@Override
	public void render() {



		Gdx.gl.glClearColor(0, 0.39f, 0, 1); // Wartości RGB dla ciemnego zielonego koloru
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);





		if(update()){}
			else
		upadek();


		batch.begin();

		batch.draw(tmp,0,0);
		if (posiada_klocek == true) {
			batch.draw(textureRegion, obj.x, obj.y);



		}
		batch.end();
		if(Zapis){
			zapis();
			Zapis= false;
		}
	}

	@Override
	public void dispose() {
		batch.dispose();

	}
		private void upadek(){
			elapsedTime1 += Gdx.graphics.getDeltaTime();
			if (elapsedTime1 >= 1.0f && mapa.Kolizja(obj,false,-50)) {
				elapsedTime1 = 0;
				obj.y -= 50;
				odcinek = (-50);
				obj.Poruszanie(odcinek,false);
			}
		}
	private boolean update() {
		boolean poziomo = false;
		boolean rusza_sie = false;
		elapsedTime += Gdx.graphics.getDeltaTime();

		if(elapsedTime >= 0.15f) {
			elapsedTime = 0;

			 {

				if (Gdx.input.isKeyPressed(Input.Keys.A)) {
					rusza_sie = true;
					poziomo = true;
					odcinek = -50;

				} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
					rusza_sie = true;
					poziomo = true;
					odcinek = 50;


				} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
					rusza_sie = true;
					poziomo = false;
					odcinek = -50;


				}
				if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
					obj.Tranformacja();
					textureRegion = new TextureRegion(obj.getTekstura(), obj.X_Region, obj.Y_Region, obj.szerokosc, obj.wysokosc);
				}

				if(mapa.Kolizja(obj,poziomo,odcinek)==true && rusza_sie){
					if(poziomo){
						obj.Poruszanie(odcinek,poziomo);
						obj.x = obj.x + odcinek;
					}else {
						obj.Poruszanie(odcinek,poziomo);

						obj.y = obj.y + odcinek;
					}
					return true;
				}
			}
			if (posiada_klocek == false) {
				posiada_klocek = true;
				obj = new Obiekty();
				obj.Losowanie();
				textureRegion = new TextureRegion(obj.getTekstura(), obj.szerokosc, obj.wysokosc);

			}
		}
		return false;
	}

	static public void zapis(){
		try {
			byte[] pixels = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
			Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
			BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);

			// Użyj pełnej ścieżki do pliku (np. "/ścieżka/do/pliku/tmp1.png")
			FileHandle fileHandle = Gdx.files.absolute("C:\\Users\\User\\Desktop\\Tetris\\assets\\tmp1.png");
			PixmapIO.writePNG(fileHandle, pixmap);
			pixmap.dispose();

			System.out.println("Zrzut ekranu został zapisany do pliku PNG: " + fileHandle.file().getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Błąd podczas zapisywania do pliku PNG: " + e.getMessage());
		}

		posiada_klocek = false;
		tmp = new Texture("C:\\Users\\User\\Desktop\\Tetris\\assets\\tmp1.png");
		Zapis = false;
	}
	void jednorazowo(){
		Texture texture = new Texture("0.bmp");
		for(int i=0;i<16;i++){
			batch.draw(texture,0,i*50);
		}
		for(int i=0;i<16;i++){
			batch.draw(texture,750,i*50);
		}
		for(int i=0;i<16;i++){
			batch.draw(texture,i*50,0);
		}
	}

}