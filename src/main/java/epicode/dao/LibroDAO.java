package epicode.dao;

import epicode.entities.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibroDAO{

    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }


    //QUERY PER RICERCA TRAMITE AUTORE
    public Elemento getByAutore(String autore) {
        String jpql = "SELECT e FROM Libro e WHERE e.autore = :autore";
        Query query = em.createQuery(jpql);
        query.setParameter("autore", autore);
        try {
            return (Elemento) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento realizzato da " + autore + " non trovato.");
            return null;
        }
    }


    public List<Object[]> findAll() {
        String jpql = "SELECT e.codiceISBN, e.titolo, e.annoPubblicazione, e.numeroPagine, l.autore, l.genere " +
                "FROM Libro l JOIN l AS e";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
}

