package epicode;
import com.github.javafaker.Faker;
import epicode.Enum.Periodicita;
import epicode.Enum.TipoElemento;
import epicode.dao.*;
        import epicode.entities.*;
        import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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





//AGGIUNTA ELEMENTO AL CATALAGO
        String titolo = faker.book().title();
        int annoPubblicazione = faker.number().numberBetween(1900, 2025);
        int numeroPagine = faker.number().numberBetween(100, 1000);
        TipoElemento tipoElemento = TipoElemento.LIBRO;

        Elemento nuovoElemento = new Elemento(titolo, annoPubblicazione, numeroPagine, tipoElemento);

        elementoDAO.addElemento(nuovoElemento);


   //RIMOZIONE ELEMENTO DAL CATALOGO
        long codiceISBNDaEliminare = 588;
        elementoDAO.deleteElemento(codiceISBNDaEliminare);

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


        //RICERCA PER ISBN
        long codiceISBN= 123456789;
        Elemento elemento = elementoDAO.getByISBN(codiceISBN);
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento);
        }

        //RICERCA PER ANNO DI PUBBLICAZIONE
        int annoDiPubblicazione= 2011;
        Elemento elemento2 = elementoDAO.getByAnno(annoDiPubblicazione);
        if (elemento2 != null) {
            System.out.println("Elemento trovato: " + elemento2);
        }

        //RICERCA PER AUTORE
        String autore= "Clodovea Ferrari";
        Elemento elemento3 = libroDAO.getByAutore(autore);
        if (elemento3 != null) {
            System.out.println("Libro trovato: " + elemento3);
        }

        //RICERCA PER TITOLO
        String titolo1= "O Jerusalem!";
        Elemento elemento4 = elementoDAO.getByTitolo(titolo1);
        if (elemento4 != null) {
            System.out.println("Elemento trovato: " + elemento4);
        }

//RICERCA PRESTITI SCADUTI E NON RESTITUITI
        List<Prestito> prestitiScaduti = prestitoDAO.getPrestitiScaduti();

        if (prestitiScaduti.isEmpty()) {
            System.out.println("Non ci sono prestiti scaduti.");
        } else {
            System.out.println("Prestiti scaduti(mostrerò solo i primi 10):");
            for (Prestito prestito : prestitiScaduti) {
                System.out.println(prestito);
            }
        }



        //CREAZIONE DEI PRESTITI
        Prestito prestito1 = new Prestito(utenteDAO.getById(577), Arrays.asList(elementoDAO.getById(584)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito2 = new Prestito(utenteDAO.getById(578), Arrays.asList(elementoDAO.getById(585)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito3 = new Prestito(utenteDAO.getById(579), Arrays.asList(elementoDAO.getById(586)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito4 = new Prestito(utenteDAO.getById(580), Arrays.asList(elementoDAO.getById(587)), LocalDate.of(2024,1,1),null);
        Prestito prestito5 = new Prestito(utenteDAO.getById(581), Arrays.asList(elementoDAO.getById(588)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito6 = new Prestito(utenteDAO.getById(582), Arrays.asList(elementoDAO.getById(589)), LocalDate.of(2024,1,1),null);
        Prestito prestito7 = new Prestito(utenteDAO.getById(583), Arrays.asList(elementoDAO.getById(590)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito8 = new Prestito(utenteDAO.getById(584), Arrays.asList(elementoDAO.getById(591)), LocalDate.of(2024,1,1),null);
        Prestito prestito9 = new Prestito(utenteDAO.getById(585), Arrays.asList(elementoDAO.getById(592)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));
        Prestito prestito10 = new Prestito(utenteDAO.getById(586), Arrays.asList(elementoDAO.getById(593)), LocalDate.of(2024,1,1),LocalDate.of(2024,2,20));


        prestitoDAO.save(prestito1);
        prestitoDAO.save(prestito2);
        prestitoDAO.save(prestito3);
        prestitoDAO.save(prestito4);
        prestitoDAO.save(prestito5);
        prestitoDAO.save(prestito6);
        prestitoDAO.save(prestito7);
        prestitoDAO.save(prestito8);
        prestitoDAO.save(prestito9);
        prestitoDAO.save(prestito10);




       // emf.close();
  }


}
