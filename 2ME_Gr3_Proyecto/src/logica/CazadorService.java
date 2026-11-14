package logica;

import almacenamiento.PersonajeDAO_BD;
import model.Cazador;

public class CazadorService {
    private int SALUD = 110;
    private int AGILIDAD = 20;
    private int VINCULO_ESPIRITUAL = 10;
    private PersonajeDAO_BD dao;

    public CazadorService(PersonajeDAO_BD dao) {
        this.dao = dao;
    } // fin constructor

    public void registrarCazador(String nombre, int experiencia) {
        Cazador auxCazador = new Cazador(nombre, SALUD, SALUD, experiencia, AGILIDAD, VINCULO_ESPIRITUAL);
        this.dao.guardarCazador(auxCazador);
    } // fin registrar

} // fin clase