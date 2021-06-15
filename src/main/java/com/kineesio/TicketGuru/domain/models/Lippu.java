package com.kineesio.TicketGuru.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "liput")
public class Lippu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lippuID;

    @NotNull(message = "Lippuun tulee määrittää lippukategoria")
    @ManyToOne
    @JoinColumn(name = "lippukategoriaID")
    private Lippukategoria lippukategoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tilausID")
    private Tilaus tilaus;

    private String lippuhash = UUID.randomUUID().toString();


    private Date kaytetty;


    public Lippu() {

    }

    public Lippu(@NotNull(message = "Lippuun tulee määrittää lippukategoria") Lippukategoria lippukategoria, @NotNull Tilaus tilaus, String lippuhash, Date kaytetty) {
        this.lippukategoria = lippukategoria;
        this.tilaus = tilaus;
        this.lippuhash = lippuhash;
        this.kaytetty = kaytetty;
    }

    @Override
    public String toString() {
        return "Lippu{" +
                "lippuID=" + lippuID +
                ", lippukategoria=" + lippukategoria +
                ", tilaus=" + tilaus +
                ", lippuhash='" + lippuhash + '\'' +
                ", kaytetty=" + kaytetty +
                '}';
    }

    public Long getLippuID() {
        return lippuID;
    }

    public void setLippuID(Long lippuID) {
        this.lippuID = lippuID;

    }

    public Lippukategoria getLippukategoria() {
        return lippukategoria;
    }

    public void setLippukategoria(Lippukategoria lippukategoria) {
        this.lippukategoria = lippukategoria;
    }

    public Tilaus getTilaus() {
        return tilaus;
    }

    public void setTilaus(Tilaus tilaus) {
        this.tilaus = tilaus;
    }

    public String getLippuhash() {
        return lippuhash;
    }

    public void setLippuhash(String lippuhash) {
        this.lippuhash = lippuhash;
    }

    public Date getKaytetty() {
        return kaytetty;
    }

    public void setKaytetty(Date kaytetty) {
        this.kaytetty = kaytetty;
    }
}



