package com.kineesio.TicketGuru.web.controller;

import com.kineesio.TicketGuru.domain.models.Kayttaja;
import com.kineesio.TicketGuru.domain.models.KayttajaDTO;
import com.kineesio.TicketGuru.domain.repositories.KayttajaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class KayttajaController {
    private final PasswordEncoder passwordEncoder;
    private final KayttajaRepository kayttajaRepository;


    public KayttajaController(KayttajaRepository kayttajaRepository, PasswordEncoder passwordEncoder) {
        this.kayttajaRepository = kayttajaRepository;
        this.passwordEncoder = passwordEncoder;


    }

    @RequestMapping(value = "/api/kayttajat/service/uusiKayttaja", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody @Valid KayttajaDTO kayttajaDTO) throws DataIntegrityViolationException {

        try {
            String pwd = kayttajaDTO.getSalasana();
            String hashPwd = passwordEncoder.encode(pwd);
            System.out.println(pwd);
            System.out.println(hashPwd);
            Kayttaja uusiKayttaja = new Kayttaja();
            uusiKayttaja.setSalasana(hashPwd);
            uusiKayttaja.setEmail(kayttajaDTO.getEmail());
            uusiKayttaja.setKayttajanimi(kayttajaDTO.getKayttajanimi());
            uusiKayttaja.setRoolit(kayttajaDTO.getRoolit());
            uusiKayttaja.setEtunimi(kayttajaDTO.getEtunimi());
            uusiKayttaja.setSukunimi(kayttajaDTO.getSukunimi());

            kayttajaRepository.save(uusiKayttaja);
            return new ResponseEntity<String>(uusiKayttaja.toString(), HttpStatus.OK);
        } catch (DataIntegrityViolationException d) {
            return new ResponseEntity<String>("Käyttäjä tai sähköpostiosoite jo käytössä", HttpStatus.BAD_REQUEST);
        }
    }
}