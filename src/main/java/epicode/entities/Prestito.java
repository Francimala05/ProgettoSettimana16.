package epicode.entities;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name="Prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name= "id_Utente")
    private Utente utente;

    @ManyToMany
    @JoinTable(name= "Prestito_per_Elemento", joinColumns =
    @JoinColumn(name="prestito_id"),inverseJoinColumns = @JoinColumn(name="codiceISBN"))

    private List <Elemento> elemento;

    private LocalDate dataInizioPrestito;
    private LocalDate dataFinePrestito;
    private LocalDate dataRestituzione;


    public Prestito() {}

    public Prestito(Utente utente, List <Elemento> elemento, LocalDate dataInizioPrestito, LocalDate dataRestituzione) {
        this.utente = utente;
        this.elemento = elemento;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataFinePrestito = dataInizioPrestito.plusDays(30);
        this.dataRestituzione = dataRestituzione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Elemento> getElemento() {
        return elemento;
    }

    public void setElemento(List<Elemento> elemento) {
        this.elemento = elemento;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento=" + elemento +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataRestituzione=" + dataRestituzione +
                '}';
    }
}
