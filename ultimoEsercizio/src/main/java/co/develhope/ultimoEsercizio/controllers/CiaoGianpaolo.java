package co.develhope.ultimoEsercizio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Gian")
public class CiaoGianpaolo {

    @GetMapping("/")
    public String ciaoGian() {
        return "Se ripenso al mio primo checkpoint, madò che ansia," +
                "non posso non ringraziarti per tutto l'impegno che ci metti nel lavoro" +
                "per insegnarci la via del dev :)";
    }

}

