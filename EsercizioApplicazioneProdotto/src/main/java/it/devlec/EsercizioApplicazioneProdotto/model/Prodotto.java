package it.devlec.EsercizioApplicazioneProdotto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Date dataacquisto,datascadenza;

    private Float prezzo,quantita;

    public Prodotto() {
    }

    public Prodotto(Long id, String nome, Date dataAcquisto, Date dataScadenza, Float prezzo, Float quantita) {
        this.id = id;
        this.nome = nome;
        this.dataacquisto = dataAcquisto;
        this.datascadenza = dataScadenza;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String nome, Date dataAcquisto, Date dataScadenza, Float prezzo, Float quantita) {
        this.nome = nome;
        this.dataacquisto = dataAcquisto;
        this.datascadenza = dataScadenza;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String nome, Date dataAcquisto, Float prezzo, Float quantita) {
        this.nome = nome;
        this.dataacquisto = dataAcquisto;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String nome, Float prezzo, Float quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String nome, Float prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAcquisto() {
        return dataacquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataacquisto = dataAcquisto;
    }

    public Date getDataScadenza() {
        return datascadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.datascadenza = dataScadenza;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    public Float getQuantita() {
        return quantita;
    }

    public void setQuantita(Float quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataAcquisto=" + dataacquisto +
                ", dataScadenza=" + datascadenza +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                '}';
    }
}
