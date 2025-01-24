package epicode.dao;

import epicode.entities.Prestito;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(prestito);
            t.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Prestito getById(long id) {
        return em.find(Prestito.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Prestito found = em.find(Prestito.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Prestito eliminato");
            } else {
                System.out.println("Prestito non trovato");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
