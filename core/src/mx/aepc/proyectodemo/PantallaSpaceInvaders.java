package mx.aepc.proyectodemo;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/*
representa un clon del juego
autor: amauri perez
 */

public class PantallaSpaceInvaders extends Pantalla
{
    private  Juego juego;

    //Enemigos
    private Alien alien; //borrar esto
    //private Array<Alien> arrAliens; //guardar todos los aliens

    //Personajes jugables
    private Nave nave;

    public PantallaSpaceInvaders(Juego juego) {
        this.juego=juego;
    }


    //Inicializan todos los objetos bala alien etc.
    @Override
    public void show() {
        crearEnemigos();
        crearNave();
    }

    private void crearNave() {
        //Texture texturaNave= new Texture("space/nave.png");
        //nave= new Nave(texturaNave,ANCHO/2,.07f*ALTO);
    }

    private void crearEnemigos() {
        Texture texturaAlien= new Texture("imagenes/enemigoArriba.png");
        alien= new Alien(texturaAlien,ANCHO/2,ALTO/2);

        //crear 55 aliens(11 columnas x5 filas)

        /*
        arrAliens = new Array<>(11*5);
        for(int renglon=0; renglon<5; renglon++)
        {
            for(int columna=0; columna<11; columna++)
            {
                Alien alien= new Alien(texturaAlien,310+(columna*60),renglon*60);
                arrAliens.add(alien); //lo guarda en el arreglo
            }
        }*/
    }

    //vamos a dibujar aca
    @Override
    public void render(float delta) {
        borrarPantalla(0,0,0);

        batch.setProjectionMatrix(camara.combined);

        batch.begin();

        alien.render(batch);
        /*
        for (Alien alien:arrAliens) {
            alien.render(batch); //Automaticamente visita cada objeto del arreglo
        }

        //Dibujar nave
        nave.render(batch);
        */

        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
