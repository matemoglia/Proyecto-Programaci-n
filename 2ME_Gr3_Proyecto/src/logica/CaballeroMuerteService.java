package logica;

import almacenamiento.PersonajeDAO_BD;
import model.CaballeroMuerte;
import model.Personaje;

public class CaballeroMuerteService {
    private int SALUD = 140;
    private int FUERZA = 25;
    private PersonajeDAO_BD dao;

    public CaballeroMuerteService(PersonajeDAO_BD dao) {
        this.dao = dao;
    } // fin constructor

    public void registrarCaballeroMuerte(String nombre, int experiencia) {
        CaballeroMuerte auxCaballeroM = new CaballeroMuerte(nombre, SALUD, SALUD, experiencia, FUERZA);
        this.dao.guardarCaballeroMuerte(auxCaballeroM);
    } // fin registrar

    public void activarPoderRunico(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof CaballeroMuerte) {
                ((CaballeroMuerte) auxPersonaje).activarPoder();
                this.dao.actualizarEstadoEspecial(nombre, ((CaballeroMuerte) auxPersonaje).tienePoderRunico());
            }
        }
    } // fin activarPoder

    public void desactivarPoderRunico(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            if (auxPersonaje instanceof CaballeroMuerte) {
                ((CaballeroMuerte) auxPersonaje).desactivarPoder();
                this.dao.actualizarEstadoEspecial(nombre, ((CaballeroMuerte) auxPersonaje).tienePoderRunico());

            }
        }
    } // fin desactivarPoder

} // fin clase