package cl.ucn.modelo;

import java.util.List;

import cl.ucn.interfaz.proxy;
import cl.ucn.util.*;

public class Databaseproxy implements proxy{
    private Databaseconec conexion;
    private  Util util;

    
    public Databaseproxy() {
        this.conexion = new Databaseconec(89830291, "SELECT u from Usuario u WHERE u.rut = :rut");
        this.util = new Util();
    }
    @Override
    public String mostrar(){
        if (conexion.mostrar() == null) {
            int comparador = conexion.getRut();
            List<Usuario> usuarios = util.loadCsv();
            for(Usuario usuario : usuarios){
                if(comparador == usuario.getRut()){
                    System.out.println("El usuario " + usuario.getNombre() + " existe en el csv");
                    return usuario.getNombre();
                };
            }
            
        }else {conexion.mostrar();}
        return null;
    }

};