package com.kineesio.TicketGuru.web.controller;


import com.kineesio.TicketGuru.domain.models.Lippu;
import com.kineesio.TicketGuru.domain.models.LippuDTO;
import com.kineesio.TicketGuru.domain.repositories.LippuRepository;
import com.kineesio.TicketGuru.domain.repositories.LippukategoriaRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class LippuController {

    private final LippuRepository lippuRepository;
    private final LippukategoriaRepository lippukategoriaRepository;

    public LippuController(LippuRepository lippuRepository, LippukategoriaRepository lippukategoriaRepository) {
        this.lippuRepository = lippuRepository;
        this.lippukategoriaRepository = lippukategoriaRepository;

    }

    @PatchMapping("/api/liput/service/kaytaLippu")
    public ResponseEntity kaytaLippu(@Valid @RequestBody LippuDTO lippuDTO) {


        Lippu lippu = lippuRepository.findBylippuhash(lippuDTO.getLippuhash());

        try {

            if (lippu.getKaytetty() == null) {
                lippu.setKaytetty(lippuDTO.getKaytetty());
                lippuRepository.save(lippu);

                return ResponseEntity.ok().body("OK");

            } else {

                return ResponseEntity.ok().body("Lippu on jo käytetty");
            }
        } catch (NullPointerException np) {
            return ResponseEntity.badRequest().body("Lippuhash oli virheellinen!");
        }
    }

    @GetMapping("api/liput/service/lippuTiedot/{lippuhash}")
    public JSONObject QR_Lippu(@PathVariable String lippuhash) {

        JSONObject vastine = new JSONObject();

        try {
            Lippu lippu = lippuRepository.findBylippuhash(lippuhash);
            if (lippu.getTilaus() == null) {
                vastine.appendField("Virhe:", "Lippua ei löydy.");

            } else {

                vastine.appendField("Lippuhash", lippu.getLippuhash());
                vastine.appendField("Tapahtuma", lippu.getLippukategoria().getTapahtuma().getKuvaus());
                vastine.appendField("Käytetty", lippu.getKaytetty());
                vastine.appendField("Lippukategoria", lippu.getLippukategoria().getLippukategoria());
                vastine.appendField("Hinta", lippu.getLippukategoria().getHinta());
                vastine.appendField("Tilaus", lippu.getTilaus().getTilausID());
                vastine.appendField("Myyjä", lippu.getTilaus().getKayttaja().getEtunimi() + " " + lippu.getTilaus().getKayttaja().getSukunimi());


            }
        } catch (NullPointerException np) {
            return vastine.appendField("Error:", "Lippua ei löydy! Tarkista hash!");
        }


        return vastine;
    }


}
