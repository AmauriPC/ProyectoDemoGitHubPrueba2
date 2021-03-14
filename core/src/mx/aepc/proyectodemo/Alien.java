package mx.aepc.proyectodemo;

/*
representa los aliens/enemigos en el juego
autor: Amauri Perez
 */

import com.badlogic.gdx.graphics.Texture;

public class Alien extends Objeto{

    public Alien(Texture texture, float x, float y)
    {
        super(texture,x,y); //El constructor de la superclase inicialize el sprite

    }

    //mover
    public void moverHorizontal(float dx)//dx que tanto quiero que se mueva de x pixeles
    {
        sprite.setX(sprite.getX()+dx);
    }

    //dibujar (ya lo heredo)


    //disparar
}
