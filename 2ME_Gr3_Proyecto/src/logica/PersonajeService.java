package logica;

import almacenamiento.PersonajeDAO_BD;
import model.Personaje;

public class PersonajeService {
    private PersonajeDAO_BD dao;

    public PersonajeService(PersonajeDAO_BD dao) {
        this.dao = dao;
    } // fin constructor

    public void recibirAtaquePersonaje(String nombre, int daño) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            auxPersonaje.recibirAtaque(daño);
            this.dao.actualizarSalud(nombre, auxPersonaje.getSaludActual());
        }
    } // fin recibirAtaque

    public int generarAtaquePersonaje(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            return auxPersonaje.generarAtaque();
        }
        return 0;
    } // fin generarAtaque

    public void curarPersonaje(String nombre, int cantidad) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            int nuevaSalud = auxPersonaje.getSaludActual() + cantidad;
            if (nuevaSalud > auxPersonaje.getSaludMaxima()) {
                nuevaSalud = auxPersonaje.getSaludMaxima();
            }
            auxPersonaje.actualizarSalud(nuevaSalud);
            this.dao.actualizarSalud(nombre, nuevaSalud);
        }
    }

    public String mostrarPersonaje(String nombre) {
        Personaje auxPersonaje = this.dao.buscarPersonaje(nombre);
        if (auxPersonaje != null) {
            return auxPersonaje.toString();
        }
        return "No existe un personaje con ese nombre";
    } // fin mostrar



} // fin clase