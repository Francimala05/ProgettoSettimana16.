package epicode.entities;


import epicode.Enum.Periodicita;
import epicode.Enum.TipoElemento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends Elemento{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(){
    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine, TipoElemento.RIVISTA);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString()+ ","+
                "periodicita=" + periodicita +
                '}';
    }
}
