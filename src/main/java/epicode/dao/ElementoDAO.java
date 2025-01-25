package epicode.dao;

import epicode.entities.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ElementoDAO {
    private EntityManager em;

    public ElementoDAO(EntityManager em) {
        this.em = em;
    }

    //QUERY PER RICERCA TRAMITE ISBN
    public Elemento getByISBN(long codiceISBN) {
        String jpql = "SELECT e FROM Elemento e WHERE e.codiceISBN = :codiceISBN";
        Query query = em.createQuery(jpql);
        query.setParameter("codiceISBN", codiceISBN);
        try {
            return (Elemento) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento con ISBN " + codiceISBN + " non trovato.");
            return null;
        }
    }

    //QUERY PER RICERCA TRAMITE ANNO
    public Elemento getByAnno(int annoDiPubblicazione) {
        String jpql = "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :annoPubblicazione";
        Query query = em.createQuery(jpql);
        query.setParameter("annoPubblicazione", annoDiPubblicazione);
        try {
            return (Elemento) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento con anno di pubblicazione " + annoDiPubblicazione + " non trovato.");
            return null;
        }
    }

    //QUERY PER RICERCA TRAMITE TITOLO
    public Elemento getByTitolo(String titolo) {
        String jpql = "SELECT e FROM Elemento e WHERE e.titolo = :titolo";
        Query query = em.createQuery(jpql);
        query.setParameter("titolo", titolo);
        try {
            return (Elemento) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento con titolo " + titolo + " non trovato.");
            return null;
        }
    }

//QUERY PER L'AGGIUNTA DI UN ELEMENTO
    public void addElemento(Elemento elemento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(elemento);

            transaction.commit();
            System.out.println("Elemento aggiunto: " + elemento);

        } catch (Exception e) {
            System.out.println("Errore durante l'inserimento dell'elemento: " + e.getMessage());
            transaction.rollback();
        }
    }


    //FUNZIONE PER RIMUOVERE ELEMENTO
    public void deleteElemento(long codiceISBN) {
        try {
            String checkPrestitoQuery = "SELECT p FROM Prestito p JOIN p.elemento e WHERE e.codiceISBN = :codiceISBN";
            Query queryPrestito = em.createQuery(checkPrestitoQuery);
            queryPrestito.setParameter("codiceISBN", codiceISBN);
            if (!queryPrestito.getResultList().isEmpty()) {
                System.out.println("Impossibile eliminare l'elemento con ISBN " + codiceISBN + " perché è ancora in prestito.");
            }
            EntityTransaction t = em.getTransaction();
            Elemento found = em.find(Elemento.class, codiceISBN);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento con ISBN " + codiceISBN + " eliminato.");
            } else {
                System.out.println("Elemento con ISBN " + codiceISBN + " non trovato.");
            }
        } catch (Exception e) {
            System.out.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }
    }


    public Elemento getById(long id) {
        return em.find(Elemento.class, id);
    }


}
