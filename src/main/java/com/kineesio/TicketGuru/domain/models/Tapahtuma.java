package com.kineesio.TicketGuru.domain.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tapahtumat")
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tapahtumaID;

    @NotNull(message = "Kuvaus ei voi olla tyhjä")
    @Size(min = 2, max = 100, message = "Kuvauksen tulee olla 2 - 100 merkkiä.")
    private String kuvaus;

    @NotNull(message = "Kapasiteetti ei voi olla tyhjä")
    @Min(1)
    @PositiveOrZero(message = "Kapasiteetti tulee määritellä. Ei voi olla negatiivinen.")
    private Integer kapasiteetti;

    @NotNull(message = "Tapahtuman aloitusaika tulee määritellä")
    private Date alkuaika;

    @NotNull(message = "Tapahtuman tapahtumapaikka tulee määritellä")
    @ManyToOne
    @JoinColumn(name = "tapahtumapaikkaID")
    private Tapahtumapaikka tapahtumapaikka;


    @OneToMany(mappedBy = "tapahtuma")
    private List<Lippukategoria> lippukategoriat;

    public Tapahtuma() {

    }


    public Tapahtuma(@NotNull(message = "Kuvaus ei voi olla tyhjä") @Size(min = 2, max = 100, message = "Kuvauksen tulee olla 2 - 100 merkkiä.") String kuvaus, @NotNull(message = "Kapasiteetti ei voi olla tyhjä") @Min(1) @PositiveOrZero(message = "Kapasiteetti tulee määritellä. Ei voi olla negatiivinen.") Integer kapasiteetti, @NotNull(message = "Tapahtuman aloitusaika tulee määritellä") Date alkuaika, @NotNull(message = "Tapahtuman tapahtumapaikka tulee määritellä") Tapahtumapaikka tapahtumapaikka, List<Lippukategoria> lippukategoriat) {
        this.kuvaus = kuvaus;
        this.kapasiteetti = kapasiteetti;
        this.alkuaika = alkuaika;
        this.tapahtumapaikka = tapahtumapaikka;
        this.lippukategoriat = lippukategoriat;
    }

    @Override
    public String toString() {
        return "Tapahtuma{" +
                "tapahtumaID=" + tapahtumaID +
                ", kuvaus='" + kuvaus + '\'' +
                ", kapasiteetti=" + kapasiteetti +
                ", alkuaika=" + alkuaika +
                ", tapahtumapaikka=" + tapahtumapaikka +
                ", lippukategoriat=" + lippukategoriat +
                '}';
    }

    public Long getTapahtumaID() {
        return tapahtumaID;
    }

    public void setTapahtumaID(Long tapahtumaID) {
        this.tapahtumaID = tapahtumaID;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public Integer getKapasiteetti() {
        return kapasiteetti;
    }

    public void setKapasiteetti(Integer kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }

    public Date getAlkuaika() {
        return alkuaika;
    }

    public void setAlkuaika(Date alkuaika) {
        this.alkuaika = alkuaika;
    }

    public Tapahtumapaikka getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(Tapahtumapaikka tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    public List<Lippukategoria> getLippukategoriat() {
        return lippukategoriat;
    }

    public void setLippukategoriat(List<Lippukategoria> lippukategoriat) {
        this.lippukategoriat = lippukategoriat;
    }
}
