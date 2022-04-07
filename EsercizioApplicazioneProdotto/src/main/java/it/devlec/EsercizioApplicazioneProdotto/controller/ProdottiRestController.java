package it.devlec.EsercizioApplicazioneProdotto.controller;

import it.devlec.EsercizioApplicazioneProdotto.avviso.ProdottoNonTrovato;
import it.devlec.EsercizioApplicazioneProdotto.model.Prodotto;
import it.devlec.EsercizioApplicazioneProdotto.persistence.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottiRestController {
    private ProdottiRepository repository;
    private static Logger logger = LoggerFactory.getLogger(ProdottiRestController.class);
    ProdottiRestController(ProdottiRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/prodotti")
    private List<Prodotto> tuttiProdotti(){
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }

    @GetMapping("/prodottopernome")
    public List<Prodotto> trovaProdottoConNome(@RequestParam(name = "nome") String nome) {
        return repository.findByNome(nome);
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciNuovoProdotto(@RequestBody Prodotto nuovoProdotto) {
        return repository.save(nuovoProdotto);
    }



    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
        return repository.save(prodotto);
    }

    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/prodotti/ricercaprezzo")
    public List<Prodotto> ricercaPerPrezzo(@RequestParam(name="min") float min,
                                           @RequestParam(name="max") float max){
        return repository.findByprezzoBetween(min,max);
    }

    @GetMapping("/prodotti/ricercadataacquisto")
    public List<Prodotto> ricercaPerDataDiAcquisto(@RequestParam(name="datada") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                                                Date datada,
                                                        @RequestParam(name="dataa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                                                Date dataa){
        return repository.findBydataacquistoBetween(datada,dataa);
    }

    @GetMapping("/prodotti/quantitainferiore")
    public List<Prodotto> ricercaPerQuantitaInferirore(@RequestParam(name="max") float max){
        return repository.findByquantitaLessThan(max);
    }


    @PostMapping ("/caricafile")
    public  String caricaFile(@RequestParam ("file") MultipartFile file){
        String infoFile= file.getOriginalFilename() + " - "+file.getContentType();
        String conFormat = String.format("%S-%S", file.getOriginalFilename(),file.getContentType());
        logger.info((infoFile));
        logger.warn(conFormat);
        return conFormat;
    }
}
