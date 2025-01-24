package epicode.entities;

import epicode.Enum.TipoElemento;

import javax.persistence.Entity;

@Entity
public class Libro extends Elemento{
    private String autore;
    private String genere;


    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine, TipoElemento.LIBRO);
        this.autore = autore;
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", autore='" + autore +
                ", genere='" + genere ;
    }
}
