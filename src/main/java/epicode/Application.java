package epicode;
import com.github.javafaker.Faker;
import epicode.Enum.Periodicita;
import epicode.dao.*;
        import epicode.entities.*;
        import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoSettimana16");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        ElementoDAO elementoDAO = new ElementoDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO  prestitoDAO = new PrestitoDAO(em);
        Random rndm = new Random();

// CREAZIONE DEGLI UTENTI CON FAKER
//        for (int i = 0; i < 10; i++) {
//            String nome = faker.name().firstName();
//            String cognome = faker.name().lastName();
//            LocalDate dataDiNascita = LocalDate.of(faker.number().numberBetween(1950, 2000), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28));
//            Utente utente = new Utente(nome, cognome, dataDiNascita);
//            utenteDAO.save(utente);
//        }
//
//        //CREAZIONE DEI LIBRI E DELLE RIVISTE CON FAKER
//        for (int i = 0; i < 20; i++) {
//            String titolo = faker.book().title();
//            int annoPubblicazione = faker.number().numberBetween(1900, 2025);
//            int numeroPagine = faker.number().numberBetween(20, 1000);
//
//
//            if (rndm.nextBoolean()) {
//                String autore = faker.book().author();
//                String genere = faker.book().genre();
//                Libro libro = new Libro(titolo, annoPubblicazione, numeroPagine, autore, genere);
//                elementoDAO.save(libro);
//            } else {
//                Periodicita periodicita = Periodicita.values()[faker.number().numberBetween(0, Periodicita.values().length)];
//                Rivista rivista = new Rivista(titolo, annoPubblicazione, numeroPagine, periodicita);
//                elementoDAO.save(rivista);
//            }
//        }

        //CREAZIONE DEI PRESTITI
            Prestito prestito1 = new Prestito(utenteDAO.getById(577), Arrays.asList(elementoDAO.getById(584)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito2 = new Prestito(utenteDAO.getById(577), Arrays.asList(elementoDAO.getById(584)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito3 = new Prestito(utenteDAO.getById(577), Arrays.asList(elementoDAO.getById(584)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));





          prestitoDAO.save(prestito1);
        prestitoDAO.save(prestito2);
        prestitoDAO.save(prestito3);


       // emf.close();
  }


}
