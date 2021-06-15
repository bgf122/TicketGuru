package com.kineesio.TicketGuru.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tapahtumapaikat")
public class Tapahtumapaikka {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tapahtumapaikka")
    private List<Tapahtuma> tapahtumat;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtumapaikkaID;

    @NotNull
    @Size(min = 2, max = 30, message = "Tapahtumapaikan nimessä tulee olla vähintään 2 merkkiä.")
    private String tapahtumapaikka;
    @NotNull
    @Size(min = 2, max = 50)
    private String osoite;

    @NotNull(message = "Kapasiteetti ei voi olla tyhjä")
    @Range(min = 1, message = "Kapasiteetin tulee olla vähintään 1.")
    private Integer kapasiteetti;
    @NotNull
    @NotBlank(message = "Syötä puhelinnumero")
    private String puhelinnumero;
    @NotNull
    @Size(min = 2, max = 50)
    private String yhteyshenkilo;

    public Tapahtumapaikka(
            @NotNull @Size(min = 2, max = 30, message = "Tapahtumapaikan nimessä tulee olla vähintään 2 merkkiä.") String tapahtumapaikka,
            @NotNull @Size(min = 2, max = 50) String osoite,
            @NotNull(message = "Kapasiteetti ei voi olla tyhjä") @Range(min = 1, message = "Kapasiteetin tulee olla vähintään 1.") Integer kapasiteetti,
            @NotNull @NotBlank(message = "Syötä puhelinnumero") String puhelinnumero,
            @NotNull @Size(min = 2, max = 50) String yhteyshenkilo) {
        super();
        this.tapahtumapaikka = tapahtumapaikka;
        this.osoite = osoite;
        this.kapasiteetti = kapasiteetti;
        this.puhelinnumero = puhelinnumero;
        this.yhteyshenkilo = yhteyshenkilo;
    }

    public Tapahtumapaikka(List<Tapahtuma> tapahtumat, Long tapahtumapaikkaID,
                           @NotNull @Size(min = 2, max = 30, message = "Tapahtumapaikan nimessä tulee olla vähintään 2 merkkiä.") String tapahtumapaikka,
                           @NotNull @Size(min = 2, max = 50) String osoite,
                           @NotNull(message = "Kapasiteetti ei voi olla tyhjä") @Range(min = 1, message = "Kapasiteetin tulee olla vähintään 1.") Integer kapasiteetti,
                           @NotNull @NotBlank(message = "Syötä puhelinnumero") String puhelinnumero,
                           @NotNull @Size(min = 2, max = 50) String yhteyshenkilo) {
        super();
        this.tapahtumat = tapahtumat;
        this.tapahtumapaikkaID = tapahtumapaikkaID;
        this.tapahtumapaikka = tapahtumapaikka;
        this.osoite = osoite;
        this.kapasiteetti = kapasiteetti;
        this.puhelinnumero = puhelinnumero;
        this.yhteyshenkilo = yhteyshenkilo;
    }

    public Tapahtumapaikka() {
    }

    @Override
    public String toString() {
        return "Tapahtumapaikka [tapahtumat=" + tapahtumat + ", tapahtumapaikkaID=" + tapahtumapaikkaID
                + ", tapahtumapaikka=" + tapahtumapaikka + ", osoite=" + osoite + ", kapasiteetti=" + kapasiteetti
                + ", puhelinnumero=" + puhelinnumero + ", yhteyshenkilo=" + yhteyshenkilo + "]";
    }

    public List<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public void setTapahtumat(List<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }

    public Long getTapahtumapaikkaID() {
        return tapahtumapaikkaID;
    }

    public void setTapahtumapaikkaID(Long tapahtumapaikkaID) {
        this.tapahtumapaikkaID = tapahtumapaikkaID;
    }

    public String getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(String tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public Integer getKapasiteetti() {
        return kapasiteetti;
    }

    public void setKapasiteetti(Integer kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    public String getYhteyshenkilo() {
        return yhteyshenkilo;
    }

    public void setYhteyshenkilo(String yhteyshenkilo) {
        this.yhteyshenkilo = yhteyshenkilo;
    }
}
