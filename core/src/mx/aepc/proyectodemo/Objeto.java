package mx.aepc.proyectodemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
Representa objetos en el juego(nave, bala, alien, marcador, enemigo...)
Autor: Amauri Perez
 */
public class Objeto
{
    //para que las clases que heredan puedan acceder a la variable
    protected Sprite sprite; //Imagen, posicion, rotar y escalar por ejemplo

    //constructor para inicializar el objeto con la imagen y la posicion
    public Objeto(Texture textura, float x, float y)
    {
        sprite = new Sprite(textura);
        sprite.setPosition(x,y);
    }

    //Constructor por default
    public Objeto()
    {

    }
    //Dibujar -> begin codigo... end <-
    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }
}
