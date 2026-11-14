package interfaz;

import java.util.Scanner;

import logica.CaballeroMuerteService;
import logica.CazadorService;
import logica.GuerreroService;
import logica.PersonajeService;
import logica.PicaroService;

public class MenuUI {
    private GuerreroService gService;
    private PicaroService pService;
    private CazadorService cService;
    private CaballeroMuerteService cmService;
    private PersonajeService personajeService;
    private Scanner sc;

    public MenuUI(GuerreroService gService, PicaroService pService, CazadorService cService, CaballeroMuerteService cmService, PersonajeService personajeService) {
        this.gService = gService;
        this.pService = pService;
        this.cService = cService;
        this.cmService = cmService;
        this.personajeService = personajeService;
        this.sc = new Scanner(System.in);
    } // fin constructor

    public void principal() {
        int opcion;
        do {
            mostrarMenu();
            opcion = pedirOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    } // fin principal

    private void mostrarMenu() {
        System.out.println("1 - Registrar personaje");
        System.out.println("2 - Mostrar estado");
        System.out.println("3 - Generar ataque");
        System.out.println("4 - Recibir ataque");
        System.out.println("5 - Enfurecer guerrero");
        System.out.println("6 - Calmar guerrero");
        System.out.println("7 - Ocultar picaro");
        System.out.println("8 - Desactivar sigilo picaro");
        System.out.println("9 - Activar poder runico");
        System.out.println("10 - Desactivar poder runico");
        System.out.println("11 - Curar personaje");
        System.out.println("0 - Salir");
    } // fin mostrarMenu

    private int pedirOpcion() {
        System.out.print("Ingrese la opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    } // fin pedirOpcio n

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                menuRegistrarPersonaje();
                break;
            case 2:
                String nombre = pedirNombre();
                System.out.println(this.personajeService.mostrarPersonaje(nombre));
                break;
            case 3:
                nombre = pedirNombre();
                int dañoAtaque = this.personajeService.generarAtaquePersonaje(nombre);
                System.out.println("El personaje genero un ataque de: " + dañoAtaque);
                break;
            case 4:
                nombre = pedirNombre();
                int cantidad = pedirCantidad();
                this.personajeService.recibirAtaquePersonaje(nombre, cantidad);
                break;
            case 5:
                nombre = pedirNombre();
                this.gService.enfurecerGuerrero(nombre);
                break;
            case 6:
                nombre = pedirNombre();
                this.gService.calmarGuerrero(nombre);
                break;
            case 7:
                nombre = pedirNombre();
                this.pService.ocultarPicaro(nombre);
                break;
            case 8:
                nombre = pedirNombre();
                this.pService.desactivarSigiloPicaro(nombre);
                break;
            case 9:
                nombre = pedirNombre();
                this.cmService.activarPoderRunico(nombre);
                break;
            case 10:
                nombre = pedirNombre();
                this.cmService.desactivarPoderRunico(nombre);
                break;
            case 11:
                nombre = pedirNombre();
                cantidad = pedirCuracion();
                this.personajeService.curarPersonaje(nombre, cantidad);
                break;
            case 0:
                System.out.println("Fin.");
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    } // fin procesarOpcion

    private String pedirNombre() {
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine().toUpperCase();
        return nombre;
    } // fin pedirNombre

    private int pedirExperiencia() {
        System.out.print("Ingrese el nivel de experiencia: ");
        int experiencia = sc.nextInt();
        sc.nextLine();
        return experiencia;
    } // fin pedirExperiencia

    private int pedirCantidad() {
        System.out.print("Ingrese el daño a recibir: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        return cantidad;
    } // fin pedirCantidad

    private int pedirCuracion(){
        System.out.print("Ingrese la salud a curar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        return cantidad;
    }

    private void menuRegistrarPersonaje() {
        System.out.println("1 - Guerrero");
        System.out.println("2 - Picaro");
        System.out.println("3 - Cazador");
        System.out.println("4 - Caballero de la Muerte");
        System.out.print("Ingrese el tipo: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo >= 1 && tipo <= 4) {
            String nombre = pedirNombre();
            int experiencia = pedirExperiencia();

            if (tipo == 1) {
                this.gService.registrarGuerrero(nombre, experiencia);
            } else if (tipo == 2) {
                this.pService.registrarPicaro(nombre, experiencia);
            } else if (tipo == 3) {
                this.cService.registrarCazador(nombre, experiencia);
            } else {
                this.cmService.registrarCaballeroMuerte(nombre, experiencia);
            }
        } else {
            System.out.println("Tipo invalido.");
        }
    } // fin menuRegistrarPersonaje

} // fin clase