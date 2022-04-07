package it.devlec.EsercizioApplicazioneProdotto.config;


import it.devlec.EsercizioApplicazioneProdotto.model.Prodotto;
import it.devlec.EsercizioApplicazioneProdotto.persistence.ProdottiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class Inserimento {
    @Bean
    CommandLineRunner inserimentoProdotti(ProdottiRepository repository) {
        return args -> {
            SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");

            Date dataAcquisto = data.parse("05-02-2019");
            Date dataScadenza = data.parse("10-07-2022");
            Prodotto p1 = new Prodotto("Farina",dataAcquisto,dataScadenza,1.30f,34.0f);

            dataAcquisto = data.parse("10-06-2018");
            dataScadenza = data.parse("15-05-2020");
            Prodotto p2 = new Prodotto("Formaggio",dataAcquisto,dataScadenza,6.20f,65.0f);

            dataAcquisto = data.parse("10-05-2020");
            dataScadenza = data.parse("15-07-2020");
            Prodotto p3 = new Prodotto("Pasta",dataAcquisto,dataScadenza,2.20f,10.0f);

            dataAcquisto = data.parse("10-05-2020");
            dataScadenza = data.parse("15-05-2020");
            Prodotto p4 = new Prodotto("Pesce",dataAcquisto,dataScadenza,8.20f,25.0f);

            List<Prodotto> prodotto = new ArrayList<>();
            prodotto.add(p1);
            prodotto.add(p2);
            prodotto.add(p3);
            prodotto.add(p4);
            repository.saveAll(prodotto);
        };
    }
}
