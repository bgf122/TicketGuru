CREATE TABLE kayttajat
(
    kayttajaID   BIGINT       NOT NULL AUTO_INCREMENT,
    kayttajanimi VARCHAR(50)  NOT NULL,
    salasana     VARCHAR(250) NOT NULL,
    etunimi      VARCHAR(50)  NOT NULL,
    sukunimi     VARCHAR(50)  NOT NULL,
    roolit       VARCHAR(250),
    oikeudet     VARCHAR(250),
    email        VARCHAR(100) NOT NULL,
    PRIMARY KEY (kayttajaID),
    CONSTRAINT kayttajat_unique UNIQUE (kayttajanimi, email)
);

CREATE TABLE tilaukset
(
    tilausID   BIGINT                                  NOT NULL AUTO_INCREMENT,
    pvm        TIMESTAMP                               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    loppusumma DOUBLE                                           DEFAULT (0) NOT NULL,
    kayttajaID BIGINT                                  NOT NULL,
    tila       ENUM ('KESKEN', 'VALMIS', 'PERUUTETTU') NOT NULL,
    PRIMARY KEY (tilausID),
    FOREIGN KEY (kayttajaID) REFERENCES kayttajat (kayttajaID)
);

CREATE TABLE tapahtumapaikat
(
    tapahtumapaikkaID BIGINT       NOT NULL AUTO_INCREMENT,
    tapahtumapaikka   VARCHAR(100) NOT NULL,
    osoite            VARCHAR(100) NOT NULL,
    kapasiteetti      INT          NOT NULL,
    puhelinnumero     VARCHAR(50)  NOT NULL,
    yhteyshenkilo     VARCHAR(100) NOT NULL,
    PRIMARY KEY (tapahtumapaikkaID)
);

CREATE TABLE tapahtumat
(
    tapahtumaID       BIGINT       NOT NULL AUTO_INCREMENT,
    kuvaus            VARCHAR(100) NOT NULL,
    kapasiteetti      INT          NOT NULL,
    alkuaika          datetime     NOT NULL,
    tapahtumapaikkaID BIGINT       NOT NULL,
    PRIMARY KEY (tapahtumaID),
    CONSTRAINT fk_tapahtumapaikka
        FOREIGN KEY (tapahtumapaikkaID)
            REFERENCES tapahtumapaikat (tapahtumapaikkaID)

);

CREATE TABLE lippukategoriat
(
    lippukategoriaID BIGINT       NOT NULL AUTO_INCREMENT,
    lippukategoria   VARCHAR(100) NOT NULL,
    tapahtumaID      BIGINT       NOT NULL,
    hinta            DOUBLE       NOT NULL,
    PRIMARY KEY (lippukategoriaID),
    FOREIGN KEY (tapahtumaID) REFERENCES tapahtumat (tapahtumaID)
);

CREATE TABLE liput
(
    lippuID          BIGINT       NOT NULL AUTO_INCREMENT,
    lippukategoriaID BIGINT       NOT NULL,
    tilausID         BIGINT       NOT NULL,
    lippuhash        VARCHAR(100) NOT NULL,
    kaytetty         DATETIME,
    PRIMARY KEY (lippuID),
    CONSTRAINT fk_lippukategoria
        FOREIGN KEY (lippukategoriaID)
            REFERENCES lippukategoriat (lippukategoriaID),
    CONSTRAINT fk_tilaus
        FOREIGN KEY (tilausID)
            REFERENCES tilaukset (tilausID)
            ON DELETE CASCADE
);
