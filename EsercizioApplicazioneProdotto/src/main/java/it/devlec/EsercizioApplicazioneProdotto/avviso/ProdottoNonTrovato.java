package it.devlec.EsercizioApplicazioneProdotto.avviso;

public class ProdottoNonTrovato extends RuntimeException {

    public ProdottoNonTrovato(Long id) {
        super("Eccezione : Prodotto non trovato " + id);
    }
    public ProdottoNonTrovato(String nome) {
        super("Eccezione : Prodotto non trovato " + nome);
    }
}