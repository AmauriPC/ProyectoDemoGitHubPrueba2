package mx.aepc.proyectodemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class PantallaMenu  extends Pantalla
{
    //referencia al juego principal
    private Juego juego;

    //fondo de la pantalla del menu
    private Texture texturaFondo;

    //Escena
    private Stage escenaMenu;




    public PantallaMenu(Juego juego) {
        this.juego= juego;
    }


    /*
    el show es lo que muestra, se ejecuta al inicio antes de mostrar
    aqui se inicializa todo
     */
    @Override
    public void show() {
        crearMenu();
    }

    private void crearMenu() {
        //crear fondo
        texturaFondo= new Texture("menu/FondoMenu.jpeg");

        //MENu, necesitamos una escena la escena es el contenedor de todo el menu
        escenaMenu= new Stage(vista);

        //actores botones...
        Button btnMario = crearBoton("menu/BotonMario.png", "menu/BotonMarioInverso.png");
        btnMario.setPosition(ANCHO/3,2*ALTO/3, Align.center);
        //agregar boton a la escena
        escenaMenu.addActor(btnMario);
        btnMario.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaMario(juego));
            }
        });

        Button btnSpace=  crearBoton("menu/BotonJugar.png","menu/btnInversoBotonJugar.png");
        btnSpace.setPosition(2*ANCHO/3,2*ALTO/3,Align.center);
        escenaMenu.addActor(btnSpace);
        //registrar evento de click para el boton
        btnSpace.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //cambiar de pantalla (space invaders)
                juego.setScreen(new PantallaSpaceInvaders(juego));
            }
        });



        Button btnRunner= crearBoton("menu/BotonRunner.png", "menu/BotonRunnerInverso.png");
        btnRunner.setPosition(ANCHO/3,ALTO/3,Align.center);
        escenaMenu.addActor(btnRunner);
        btnRunner.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaRunner(juego));
            }
        });


        Button btnConfig= crearBoton("menu/BotonConfig.png", "menu/BotonConfiguracionInverso.png");
        btnConfig.setPosition(2*ANCHO/3,ALTO/3,Align.center);
        escenaMenu.addActor(btnConfig);
        btnConfig.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaConfig(juego));
            }
        });



        //Escena se encarga de los eventos de entrada
        Gdx.input.setInputProcessor(escenaMenu);

    }

    private Button crearBoton(String archivo, String archivoInverso) {
        Texture texturaBoton= new Texture(archivo);
        TextureRegionDrawable trdBtnMario =new TextureRegionDrawable(texturaBoton);
        //Inverso
        Texture texturaInverso= new Texture(archivoInverso);
        TextureRegionDrawable trdBtnInverso= new TextureRegionDrawable(texturaInverso);
        return new Button(trdBtnMario,trdBtnInverso);
    }

    //se ejecuta automaticamente en 60 veces por segundo
    //delta es el tiempo q ha transcurrido entre frames
    @Override
    public void render(float delta) {
        borrarPantalla(0,1,0);

        //escalado al mundo virtual
        batch.setProjectionMatrix(camara.combined);

        //inicio de dibujo
        batch.begin();

        batch.draw(texturaFondo,0,0);


        //fin de dibujo ya no sale nada mas
        batch.end();

        //escena despues del fondo porq si no la tapa

        escenaMenu.draw(); //las escenas se pueden dibujar solas
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
