package logica;

import almacenamiento.PersonajeDAO_BD;
import model.CaballeroMuerte;
import model.Personaje;
import model.Picaro;

public class PicaroService {
    private int SALUD = 100;
    private int AGILIDAD = 25;
    private PersonajeDAO_BD dao;

    public PicaroService(PersonajeDAO_BD dao) {
        this.dao = dao;
    } // fin constructor

    public void registrarPicaro(String nombre, int experiencia) {
        Picaro auxPicaro = new Picaro(nombre, SALUD, SALUD, experiencia, AGILIDAD);
        this.dao.guardarPicaro(auxPicaro);
    } // fin registrar

    public void ocultarPicaro(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof Picaro) {
                ((Picaro) auxPersonaje).ocultarse();
                this.dao.actualizarEstadoEspecial(nombre, ((Picaro) auxPersonaje).getSigilo());

            }
        }
    } // fin ocultar

    public void desactivarSigiloPicaro(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof Picaro) {
                ((Picaro) auxPersonaje).desactivarSigilo();
                this.dao.actualizarEstadoEspecial(nombre, ((Picaro) auxPersonaje).getSigilo());

            }
        }
    } // fin desactivarSigilo

} // fin clase