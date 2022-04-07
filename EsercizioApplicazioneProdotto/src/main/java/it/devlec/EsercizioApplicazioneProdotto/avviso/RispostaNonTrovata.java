package it.devlec.EsercizioApplicazioneProdotto.avviso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RispostaNonTrovata {
    @ResponseBody
    @ExceptionHandler(ProdottoNonTrovato.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RispostaNonTrovata(ProdottoNonTrovato ex) {
        return ex.getMessage();
    }
}
