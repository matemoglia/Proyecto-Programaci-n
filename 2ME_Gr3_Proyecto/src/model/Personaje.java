package model;

public class Personaje {
    private String nombre;
    private int saludActual;
    private int saludMaxima;
    private int experiencia;

    public Personaje(String nombre, int saludActual, int saludMaxima, int experiencia) {
        if (nombre == null) {
            this.nombre = "";
        } else {
            this.nombre = nombre.toUpperCase();
        }

        if (saludMaxima < 0) {
            this.saludMaxima = 0;
        } else {
            this.saludMaxima = saludMaxima;
        }
        if (saludActual < 0) {
            this.saludActual = 0;
        } else if (saludActual > this.saludMaxima) {
            this.saludActual = this.saludMaxima;
        } else {
            this.saludActual = saludActual;
        }
        if (experiencia < 0) {
            this.experiencia = 0;
        } else {
            this.experiencia = experiencia;
        }
    } // fin constructor

    public String getNombre() {
        return this.nombre;
    }

    public int getSaludActual() {
        return this.saludActual;
    }

    public int getSaludMaxima() {
        return this.saludMaxima;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public boolean estaInhabilitado() {
        return this.saludActual == 0;
    }


    public boolean actualizarSalud(int nuevaSalud) {
        if (nuevaSalud < 0 || nuevaSalud > this.saludMaxima) {
            return false;
        }
        this.saludActual = nuevaSalud;
        return true;
    } // fin actualizarSalud

    public int generarAtaque() {
        if (this.estaInhabilitado()) {
            return 0;
        }
        return this.experiencia;
    } // fin generarAtaque

    public void recibirAtaque(int ataque) {
        if (ataque > 0 && !this.estaInhabilitado()) {
            if (ataque <= this.saludActual) {
                this.saludActual = this.saludActual - ataque;
            } else {
                this.saludActual = 0;
            }
        }
    } // fin recibirAtaque

    public String toString() {
        String estado = this.estaInhabilitado() ? " - INHABILITADO" : "";
        return this.nombre + " - salud: " + this.saludActual + "/" + this.saludMaxima
                + " - experiencia: " + this.experiencia + estado;
    }

} // fin clase