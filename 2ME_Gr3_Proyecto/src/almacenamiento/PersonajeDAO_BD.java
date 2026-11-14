package almacenamiento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CaballeroMuerte;
import model.Cazador;
import model.Guerrero;
import model.Personaje;
import model.Picaro;

public class PersonajeDAO_BD {
    private final String url = "jdbc:mysql://localhost:3306/WoW";
    private final String user = "root";
    private final String password = "matu2009";


    public PersonajeDAO_BD() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC de MySQL: " + e.getMessage());
        }
    }

    public boolean guardarGuerrero(Guerrero guerrero) {
        //Tomar los datos del personaje

        String auxnombre = guerrero.getNombre();
        int auxsaludActual = guerrero.getSaludActual();
        int auxsaludMaxima = guerrero.getSaludMaxima();
        int auxexperiencia = guerrero.getExperiencia();
        int auxfuerza = guerrero.getFuerza();
        boolean auxenfurecido = guerrero.estaEnfurecido();
        //Insertar Guerrero en sql
        String sqlInsert = "INSERT INTO personajes (nombre, salud_actual, salud_maxima, experiencia, fuerza, estado_especial, clase) VALUES ('" + auxnombre + "', " + auxsaludActual + ", " + auxsaludMaxima + ", " + auxexperiencia + ", " + auxfuerza + ", " + auxenfurecido + ", 'GUERRERO'" + ")";
        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sqlInsert);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el personaje: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarPicaro(Picaro picaro) {
        //Tomar los datos del personaje

        String auxnombre = picaro.getNombre();
        int auxsaludActual = picaro.getSaludActual();
        int auxsaludMaxima = picaro.getSaludMaxima();
        int auxexperiencia = picaro.getExperiencia();
        int auxagilidad = picaro.getAgilidad();
        boolean auxsigilo = picaro.getSigilo();
        //Insertar Picaro en sql
        String sqlInsert = "INSERT INTO personajes (nombre, salud_actual, salud_maxima, experiencia, agilidad, estado_especial, clase) VALUES ('" + auxnombre + "', " + auxsaludActual + ", " + auxsaludMaxima + ", " + auxexperiencia + ", " + auxagilidad + ", " + auxsigilo + ", 'PICARO'" + ")";
        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sqlInsert);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el personaje: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarCazador(Cazador cazador) {
        //Tomar los datos del personaje

        String auxnombre = cazador.getNombre();
        int auxsaludActual = cazador.getSaludActual();
        int auxsaludMaxima = cazador.getSaludMaxima();
        int auxexperiencia = cazador.getExperiencia();
        int auxagilidad = cazador.getAgilidad();
        int auxvinculo = cazador.getVinculoEspiritual();
        //Insertar Cazador en sql
        String sqlInsert = "INSERT INTO personajes (nombre, salud_actual, salud_maxima, experiencia, agilidad, vinculo_espiritual, clase) VALUES ('" + auxnombre + "', " + auxsaludActual + ", " + auxsaludMaxima + ", " + auxexperiencia + ", " + auxagilidad + ", " + auxvinculo + ", 'CAZADOR'" + ")";
        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sqlInsert);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el personaje: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarCaballeroMuerte(CaballeroMuerte caballeroM) {
        //Tomar los datos del personaje

        String auxnombre = caballeroM.getNombre();
        int auxsaludActual = caballeroM.getSaludActual();
        int auxsaludMaxima = caballeroM.getSaludMaxima();
        int auxexperiencia = caballeroM.getExperiencia();
        int auxfuerza = caballeroM.getFuerza();
        boolean auxpoder = caballeroM.tienePoderRunico();
        //Insertar Caballero de la muerte en sql
        String sqlInsert = "INSERT INTO personajes (nombre, salud_actual, salud_maxima, experiencia, fuerza, estado_especial, clase) VALUES ('" + auxnombre + "', " + auxsaludActual + ", " + auxsaludMaxima + ", " + auxexperiencia + ", " + auxfuerza + ", " + auxpoder + ", 'CABALLERO_MUERTE'" + ")";
        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sqlInsert);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el personaje: " + e.getMessage());
            return false;
        }
    }



    public Personaje buscarPersonaje(String nombre) {
        String sqlSelect = "SELECT * FROM personajes WHERE nombre = '" + nombre + "'";

        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()) {
            ResultSet resultado = sentencia.executeQuery(sqlSelect);
            if(resultado.next()){
                String clase = resultado.getString("clase");
                int saludActual = resultado.getInt("salud_actual");
                int saludMaxima = resultado.getInt("salud_maxima");
                int experiencia = resultado.getInt("experiencia");

                if (clase.equalsIgnoreCase("GUERRERO")) {
                    int fuerza = resultado.getInt("fuerza");
                    Guerrero auxGuerrero = new Guerrero(nombre, saludActual, saludMaxima, experiencia, fuerza);
                    if (resultado.getBoolean("estado_especial")) {
                        auxGuerrero.enfurecer();
                    }
                    return auxGuerrero;
                } else if (clase.equalsIgnoreCase("PICARO")) {
                    int agilidad = resultado.getInt("agilidad");
                    Picaro auxPicaro = new Picaro(nombre, saludActual, saludMaxima, experiencia, agilidad);
                    if (resultado.getBoolean("estado_especial")) {
                        auxPicaro.ocultarse();
                    }
                    return auxPicaro;
                } else if (clase.equalsIgnoreCase("CAZADOR")) {
                    int agilidad = resultado.getInt("agilidad");
                    int vinculo = resultado.getInt("vinculo_espiritual");
                    Cazador auxCazador = new Cazador(nombre, saludActual, saludMaxima, experiencia, agilidad, vinculo);
                    return auxCazador;
                } else if (clase.equalsIgnoreCase("CABALLERO_MUERTE")) {
                    int fuerza = resultado.getInt("fuerza");
                    CaballeroMuerte auxCaballeroM = new CaballeroMuerte(nombre, saludActual, saludMaxima, experiencia, fuerza);
                    if (resultado.getBoolean("estado_especial")) {
                        auxCaballeroM.activarPoder();
                    }
                    return auxCaballeroM;
                }
                return null;
            }else{
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar el personaje: " + e.getMessage());
            return null;
        }
    } // fin buscar

        public boolean actualizarSalud(String nombre, int salud_actual){
            String sqlUpdate = "UPDATE personajes SET salud_actual = " + salud_actual + " WHERE nombre = '" + nombre + "'";
            try (Connection conexion = DriverManager.getConnection(url, user, password);
                 Statement sentencia = conexion.createStatement()) {
                sentencia.executeUpdate(sqlUpdate);
                return true;
            } catch (SQLException e) {
                System.out.println("Error al actualizar el personaje: " + e.getMessage());
                return false;
            }
        }

        public boolean actualizarEstadoEspecial(String nombre, boolean estado_especial){
            String sqlUpdate = "UPDATE personajes SET estado_especial = " + estado_especial + " WHERE nombre = '" + nombre + "'";
        try (Connection conexion = DriverManager.getConnection(url, user, password); Statement sentencia = conexion.createStatement()){
            sentencia.executeUpdate(sqlUpdate);
            return true;
        } catch (SQLException e){
            System.out.println("Error al actualizar el personaje: " + e.getMessage());
            return false;
        }

        }

} // fin clase