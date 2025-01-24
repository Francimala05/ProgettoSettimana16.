package epicode.dao;

import epicode.entities.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ElementoDAO {
    private EntityManager em;

    public ElementoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Elemento elemento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(elemento);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Elemento getById(long id) {
        return em.find(Elemento.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Elemento found = em.find(Elemento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
