package com.kineesio.TicketGuru.domain.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lippukategoriat")
public class Lippukategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lippukategoriaID;

    @NotBlank(message = "Lippukategorian kuvaus ei voi olla tyhjä.")
    private String lippukategoria;


    @NotNull(message = "Tapahtuma tulee määritellä")
    @ManyToOne
    @JoinColumn(name = "tapahtumaID", nullable = false)
    private Tapahtuma tapahtuma;

    @DecimalMin(value = "1", message = "Hinnan tulee olla vähintään yksi ja liukuluku.")
    @NotNull(message = "Hinta ei voi olla tyhjä!")
    private Double hinta;

    public Lippukategoria(Long lippukategoriaID,
                          @NotBlank(message = "Lippukategorian kuvaus ei voi olla tyhjä.") String lippukategoria,
                          @NotNull(message = "Tapahtuman tapahtumapaikka tulee määritellä") Tapahtuma tapahtuma,
                          @DecimalMin(value = "1", message = "Hinnan tulee olla vähintään yksi ja liukuluku.") @NotNull Double hinta) {
        super();
        this.lippukategoriaID = lippukategoriaID;
        this.lippukategoria = lippukategoria;
        this.tapahtuma = tapahtuma;
        this.hinta = hinta;
    }

    public Lippukategoria() {

    }

    @Override
    public String toString() {
        return "Lippukategoria [lippukategoriaID=" + lippukategoriaID + ", lippukategoria=" + lippukategoria
                + ", tapahtuma=" + tapahtuma + ", hinta=" + hinta + "]";
    }

    public Long getLippukategoriaID() {
        return lippukategoriaID;
    }

    public void setLippukategoriaID(Long lippukategoriaID) {
        this.lippukategoriaID = lippukategoriaID;
    }

    public String getLippukategoria() {
        return lippukategoria;
    }

    public void setLippukategoria(String lippukategoria) {
        this.lippukategoria = lippukategoria;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public Double getHinta() {
        return hinta;
    }

    public void setHinta(Double hinta) {
        this.hinta = hinta;
    }

}
