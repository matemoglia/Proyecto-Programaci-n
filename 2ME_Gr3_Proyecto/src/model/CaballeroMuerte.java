package model;

public class CaballeroMuerte extends Personaje {
    private int fuerza;
    private boolean poderRunico;

    public CaballeroMuerte(String nombre, int saludActual, int saludMaxima, int experiencia, int fuerza) {
        super(nombre, saludActual, saludMaxima, experiencia);
        this.fuerza = fuerza;
        this.poderRunico = false;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void activarPoder() {
        this.poderRunico = true;
    }

    public void desactivarPoder() {
        this.poderRunico = false;
    }

    public boolean tienePoderRunico() {
        return this.poderRunico;
    }

    @Override
    public int generarAtaque() {
        int daño = 0;
        if (!this.estaInhabilitado()) {
            daño = this.fuerza + this.getExperiencia();
        }
        return daño;
    }

    @Override
    public void recibirAtaque(int ataque) {
        int reducirAtaque = ataque;
        if (this.poderRunico) {
            reducirAtaque = ataque * 7 / 10; // reduce 30%
        }
        super.recibirAtaque(reducirAtaque);
    }

    @Override
    public String toString() {
        String estado = this.poderRunico ? "activo" : "inactivo";
        return super.toString() + " - fuerza: " + this.fuerza + " - Poder rúnico: " + estado;
    }
}