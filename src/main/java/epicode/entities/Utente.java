package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Utenti")
public class Utente {

    @Id
    @GeneratedValue
    private long numeroTessera;

    private String Nome;
    private String Cognome;
    private LocalDate dataDiNascita;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;



    public Utente(){
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.Nome = nome;
        this.Cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
