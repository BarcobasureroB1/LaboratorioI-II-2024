package cl.ucn.modelo;

import cl.ucn.interfaz.proxy;
import jakarta.persistence.*;

public class Databaseconec implements proxy{
    private int rut;
    private String query;
    EntityManagerFactory emf ;
    EntityManager em;
    

    public Databaseconec(int rut, String query){
        this.rut = 89830291;
        this.query= "SELECT u from Usuario u WHERE u.rut = :rut";
        this.emf = Persistence.createEntityManagerFactory("multimediaApp");
        this.em= emf.createEntityManager() ;
    }

    public int getRut(){
        return rut;
    }

    public String mostrar(){
        TypedQuery<Usuario> query2 = em.createQuery(query, Usuario.class);
        query2.setParameter("rut", rut);
        try {
            Usuario usuario = query2.getSingleResult();
            System.out.println("El usuario: " + usuario.getRut() + " existe!");
        }catch (NoResultException e){
            System.out.println("El usuario no existe!");
            return null;
        }
        return query;
    };



}
