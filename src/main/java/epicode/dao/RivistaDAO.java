package epicode.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RivistaDAO{

    private EntityManager em;

    public RivistaDAO(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> findAll() {
        String jpql = "SELECT e.codiceISBN, e.titolo, e.annoPubblicazione, e.numeroPagine, r.periodicita " +
                "FROM Rivista r JOIN r.elemento e";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
}