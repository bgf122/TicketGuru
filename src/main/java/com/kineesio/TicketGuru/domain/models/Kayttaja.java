package com.kineesio.TicketGuru.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "kayttajat")
public class Kayttaja {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kayttajaid;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String kayttajanimi;

    @JsonIgnore
    @NotBlank
    @Column(nullable = false)
    private String salasana;

    @NotBlank
    private String etunimi;

    @NotBlank
    private String sukunimi;

    @JsonIgnore
    private String roolit = "";
    @JsonIgnore
    private String oikeudet = "";

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    public Kayttaja(@NotBlank String kayttajanimi, @NotBlank String salasana, @NotBlank String etunimi, @NotBlank String sukunimi, String roolit, String oikeudet, @Email String email) {
        this.kayttajanimi = kayttajanimi;
        this.salasana = salasana;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.roolit = roolit;
        this.oikeudet = oikeudet;
        this.email = email;
    }

    public Kayttaja() {

    }

    @Override
    public String toString() {
        return "Kayttaja [kayttajaID=" + kayttajaid + ", kayttajanimi=" + kayttajanimi + ", salasana=" + salasana
                + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", roolit=" + roolit + ", oikeudet=" + oikeudet
                + ", email=" + email + "]";
    }

    public Long getKayttajaid() {
        return kayttajaid;
    }

    public void setKayttajaid(Long kayttajaID) {
        this.kayttajaid = kayttajaID;
    }

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

    public String getOikeudet() {
        return oikeudet;
    }

    public void setOikeudet(String oikeudet) {
        this.oikeudet = oikeudet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> haeRoolit() {
        if (this.roolit.length() > 0) {
            return Arrays.asList(this.roolit.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> haeOikeudet() {
        if (this.oikeudet.length() > 0) {
            return Arrays.asList(this.oikeudet.split(","));
        }
        return new ArrayList<>();
    }

}
