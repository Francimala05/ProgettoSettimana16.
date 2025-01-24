package epicode.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibroDAO{

    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> findAll() {
        String jpql = "SELECT e.codiceISBN, e.titolo, e.annoPubblicazione, e.numeroPagine, l.autore, l.genere " +
                "FROM Libro l JOIN l AS e";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
}

