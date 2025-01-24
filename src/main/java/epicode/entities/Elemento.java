package epicode.entities;

import epicode.Enum.TipoElemento;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "elementi")
@Inheritance(strategy = InheritanceType.JOINED)
public class Elemento {
    @Id
    @GeneratedValue
    private long codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;


    @Enumerated(EnumType.STRING)
    private TipoElemento tipoElemento;

    public Elemento() {
    }

    public Elemento(String titolo, int annoPubblicazione, int numeroPagine, TipoElemento tipoElemento) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.tipoElemento = tipoElemento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", tipoElemento=" + tipoElemento +
                '}';
    }
}
