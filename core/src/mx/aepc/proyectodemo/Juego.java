package mx.aepc.proyectodemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/*
Esta clase representa la aplicacion, es decir que es todo el juego
siempre estara vivo por todo el juego, la aplicacion q corre, esta vivo durante toda la ejecucion
Autor: Amauri Elian Perez Cruz
*/
public class Juego extends Game {

	@Override
	public void create () {
		//muestre la primera pantalla que quiera visualizar cuando el juego arranque
		setScreen(new PantallaMenu(this)); //primera pantalla visible
	}
}
