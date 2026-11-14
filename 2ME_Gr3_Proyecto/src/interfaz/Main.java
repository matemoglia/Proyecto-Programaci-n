package interfaz;

import almacenamiento.PersonajeDAO_BD;
import logica.CaballeroMuerteService;
import logica.CazadorService;
import logica.GuerreroService;
import logica.PersonajeService;
import logica.PicaroService;

public class Main {

    public static void main(String[] args) {
        PersonajeDAO_BD dao = new PersonajeDAO_BD();

        GuerreroService gService = new GuerreroService(dao);
        PicaroService pService = new PicaroService(dao);
        CazadorService cService = new CazadorService(dao);
        CaballeroMuerteService cmService = new CaballeroMuerteService(dao);
        PersonajeService personajeService = new PersonajeService(dao);

        MenuUI menu = new MenuUI(gService, pService, cService, cmService, personajeService);

        menu.principal();
    }

}