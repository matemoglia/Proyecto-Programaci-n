package logica;

import almacenamiento.PersonajeDAO_BD;
import model.Guerrero;
import model.Personaje;

public class GuerreroService {
    private int SALUD = 150;
    private int FUERZA = 30;
    private PersonajeDAO_BD dao;

    public GuerreroService(PersonajeDAO_BD dao) {
        this.dao = dao;
    } // fin constructor

    public void registrarGuerrero(String nombre, int experiencia) {
        Guerrero auxGuerrero = new Guerrero(nombre, SALUD, SALUD, experiencia, FUERZA);
        this.dao.guardarGuerrero(auxGuerrero);
    } // fin registrar

    public void enfurecerGuerrero(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof Guerrero) {
                ((Guerrero) auxPersonaje).enfurecer();
                this.dao.actualizarEstadoEspecial(nombre, ((Guerrero) auxPersonaje).estaEnfurecido());
            }
        }
    } // fin enfurecer

    public void calmarGuerrero(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof Guerrero) {
                ((Guerrero) auxPersonaje).calmarse();
                this.dao.actualizarEstadoEspecial(nombre, ((Guerrero) auxPersonaje).estaEnfurecido());            }
        }
    } // fin calmar

} // fin clase