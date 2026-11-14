package model;

public class Cazador extends Personaje {
    private int agilidad;
    private int vinculoEspiritual;

    public Cazador(String nombre, int saludActual, int saludMaxima, int experiencia, int agilidad, int vinculoEspiritual) {
        super(nombre, saludActual, saludMaxima, experiencia);
        this.agilidad = agilidad;
        this.vinculoEspiritual = vinculoEspiritual;
    }

    public int getAgilidad(){
        return this.agilidad;
    }

    public int getVinculoEspiritual(){
        return this.vinculoEspiritual;
    }

    @Override
    public int generarAtaque(){
        int daño = 0;
        if (!this.estaInhabilitado()) {
            daño = this.agilidad + this.getExperiencia();
        }
        return daño;
    }

    @Override
    public void recibirAtaque(int ataque) {
        int reducirAtaque = ataque - this.vinculoEspiritual;
        if (reducirAtaque < 0) {
            reducirAtaque = 0;
        }
        super.recibirAtaque(reducirAtaque);
    }

    @Override
    public String toString() {
        return super.toString() + " - agilidad: " + this.agilidad
                + " - vinculo espiritual: " + this.vinculoEspiritual;
    }

}