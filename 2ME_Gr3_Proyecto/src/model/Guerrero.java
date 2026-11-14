package model;

public class Guerrero extends Personaje {
    private int fuerza;
    private boolean enfurecido;

    public Guerrero(String nombre, int saludActual, int saludMaxima, int experiencia, int fuerza) {
        super(nombre, saludActual, saludMaxima, experiencia);
        this.fuerza = fuerza;
        this.enfurecido = false;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void enfurecer() {
        this.enfurecido = true;
    }

    public void calmarse() {
        this.enfurecido = false;
    }

    public boolean estaEnfurecido() {
        return this.enfurecido;
    }

    @Override
    public int generarAtaque() {
        int daño = 0;
        if (!this.estaInhabilitado()) {
            daño = this.fuerza;
            if (this.enfurecido) {
                daño = daño * 3 / 2;
            }
        }
        return daño;
    }

    @Override
    public void recibirAtaque(int ataque) {
        int reducirAtaque = ataque;
        if (this.enfurecido) {
            reducirAtaque = ataque * 3 / 4;
        }
        super.recibirAtaque(reducirAtaque);
    }

    @Override
    public String toString() {
        String estado = this.enfurecido ? "enfurecido" : "calmo";
        return super.toString() + " - fuerza: " + this.fuerza + " - Estado: " + estado;
    }
}