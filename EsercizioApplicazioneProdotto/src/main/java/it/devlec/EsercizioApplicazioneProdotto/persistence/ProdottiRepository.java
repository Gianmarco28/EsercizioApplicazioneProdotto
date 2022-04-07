package it.devlec.EsercizioApplicazioneProdotto.persistence;

import it.devlec.EsercizioApplicazioneProdotto.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findByNome(String nome);
    List<Prodotto> findByprezzoBetween(float min,float max);
    List<Prodotto> findByquantitaLessThan(float max);
    List<Prodotto> findBydataacquistoBetween(Date datada,Date dataa);
}