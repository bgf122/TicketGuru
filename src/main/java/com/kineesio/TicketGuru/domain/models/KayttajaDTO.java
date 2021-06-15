package com.kineesio.TicketGuru.domain.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KayttajaDTO {

    @NotNull(message = "Käyttäjätunnus ei voi olla tyhjä")
    @Size(min = 4, max = 250, message = "Käyttäjänimen koko tulee olla 4 - 250 merkkiä")
    private String kayttajanimi;
    @NotNull(message = "Salasana ei voi olla tyhjä")
    private String salasana;
    @NotNull(message = "Etunimi ei voi olla tyhjä")
    private String etunimi;
    @NotNull(message = "Sukunimi ei voi olla tyhjä")
    private String sukunimi;
    @NotNull(message = "Rooli tulee määritellä")
    private String roolit;
    @Email(message = "Tarkista sähköpostin muoto")
    private String email;

    public String getKayttajanimi() {
        return kayttajanimi;
    }

    public void setKayttajanimi(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getRoolit() {
        return roolit;
    }

    public void setRoolit(String roolit) {
        this.roolit = roolit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

