package com.kineesio.TicketGuru.domain.models;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Validated
@Entity
@Table(name = "tilaukset")
public class Tilaus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilausID;


    private Date pvm = new Date();

    private Double loppusumma;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tilaus")
    private List<Lippu> liput;

    @NotNull(message = "Käyttäjä tulee määritellä")
    @ManyToOne
    @JoinColumn(name = "kayttajaID")
    private Kayttaja kayttaja;

    @Column(columnDefinition = "ENUM('KESKEN', 'VALMIS', 'PERUTTU')")
    @Enumerated(EnumType.STRING)
    private Tila tila;

    public Tilaus() {

    }

    public Tilaus(Date pvm, Double loppusumma, List<Lippu> liput, @NotNull(message = "Käyttäjä tulee määritellä") Kayttaja kayttaja, Tila tila) {
        this.pvm = pvm;
        this.loppusumma = loppusumma;
        this.liput = liput;
        this.kayttaja = kayttaja;
        this.tila = tila;
    }

    @Override
    public String toString() {
        return "Tilaus{" +
                "tilausID=" + tilausID +
                ", pvm=" + pvm +
                ", loppusumma=" + loppusumma +
                ", liput=" + liput +
                ", kayttaja=" + kayttaja +
                ", tila=" + tila +
                '}';
    }

    public Long getTilausID() {
        return tilausID;
    }

    public void setTilausID(Long tilausID) {
        this.tilausID = tilausID;
    }

    public Date getPvm() {
        return pvm;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    public Double getLoppusumma() {
        return loppusumma;
    }

    public void setLoppusumma(Double loppusumma) {
        this.loppusumma = loppusumma;
    }

    public List<Lippu> getLiput() {
        return liput;
    }

    public void setLiput(List<Lippu> liput) {
        this.liput = liput;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public Tila getTila() {
        return tila;
    }

    public void setTila(Tila tila) {
        this.tila = tila;
    }
}




