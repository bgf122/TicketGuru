package com.kineesio.TicketGuru.domain.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Validated
public class LippuDTO {


    @NotNull(message = "Aikaleima tulee asettaa!")
    private Date kaytetty;

    @NotNull(message = "Lippuhash ei voi olla tyhjä")
    private String lippuhash;


    public LippuDTO(@NotNull(message = "Aikaleima tulee asettaa!") Date kaytetty, String lippuhash) {
        this.kaytetty = kaytetty;
        this.lippuhash = lippuhash;
    }

    public Date getKaytetty() {
        return kaytetty;
    }

    public void setKaytetty(Date kaytetty) {
        this.kaytetty = kaytetty;
    }

    public String getLippuhash() {
        return lippuhash;
    }

    public void setLippuhash(String lippuhash) {
        this.lippuhash = lippuhash;
    }
}
