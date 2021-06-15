package com.kineesio.TicketGuru.web.controller;

import org.flywaydb.core.Flyway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final Flyway flyway;

    public WebController(Flyway flyway) {
        this.flyway = flyway;
    }

    @PostMapping("reset")
    public ResponseEntity<String> reset() {
        flyway.clean();
        flyway.migrate();

        return ResponseEntity.ok("Tietokanta alustettu.");
    }

    @GetMapping(value = "/" )
    public String index() {
        return "index";
    }


}
