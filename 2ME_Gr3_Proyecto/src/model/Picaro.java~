package model;

public class Picaro extends Personaje {
    private int agilidad;
    private boolean sigilo;

    public Picaro(String nombre, int saludActual, int saludMaxima, int experiencia, int agilidad) {
        super(nombre, saludActual, saludMaxima, experiencia);
        this.agilidad = agilidad;
        this.sigilo = false;
    }

    public int getAgilidad(){
        return this.agilidad;
    }

    public boolean getSigilo(){
        return this.sigilo;
    }

    public void ocultarse(){
        this.sigilo = true;
    }

    public void desactivarSigilo(){
        this.sigilo = false;
    }

    @Override

    public int generarAtaque(){
        int daño = 0;
        if(!this.estaInhabilitado()){
            daño = this.agilidad + this.getExperiencia();
            if(this.sigilo){
                daño += daño /2;
            }
        }
        return daño;
    }

   @Override
   public void recibirAtaque(int ataque){
        int reducirAtaque = ataque - this.agilidad /2;
        if (reducirAtaque < 0){
            reducirAtaque = 0;
        }
        super.recibirAtaque(reducirAtaque);
   }

   @Override
    public String toString(){
        String estado = this.sigilo ? "oculto" : "visible";
        return super.toString() + "agilidad: " + this.agilidad + "Estoy " + estado;
    }
}
