INSERT INTO tapahtumapaikat(tapahtumapaikka, osoite, kapasiteetti, puhelinnumero, yhteyshenkilo)
VALUES ('Tavastia', 'Yrjönkatu 11, 00100 Helsinki', 500, '09-123123', 'Jyrki Hämäläinen'),
       ('Nosturi', 'Telakkakatu 11, 00150 Helsinki', 500, '09-321 321', 'Juice Leskinen'),
       ('On the Rocks', 'Mikonkatu 11, 00100 Helsinki', 500, '09- 111 111', 'Pate Mustajärvi'),
       ('Semifinal', 'Jokukatu 11, 00100 Helsinki', 500, '09-800200', 'Mikko Alatalo');

INSERT INTO tapahtumat (kuvaus, kapasiteetti, alkuaika, tapahtumapaikkaid)
VALUES ('Tehosekoitin keikka', 50, '2020-11-5 10:00', 1),
       ('Maustetytöt keikka', 20, '2020-09-30 11:00', 2),
       ('Raamattupiiri keikka', 15, '2020-11-11 08:00', 3),
       ('Ohjelmistoprojekti I', 10, '2020-12-12 16:00', 2),
       ('Viiniseuran maisteluilta', 20, '2020-12-06 21:00', 1);

INSERT INTO lippukategoriat (lippukategoria, hinta, tapahtumaid)
VALUES ('AIKUINEN', 10, 1),
       ('LAPSI', 5, 1),
       ('ELÄKELÄINEN', 7.5, 1),
       ('AIKUINEN', 10, 2),
       ('LAPSI', 5, 2),
       ('ELÄKELÄINEN', 7.5, 2),
       ('AIKUINEN', 10, 3),
       ('LAPSI', 5, 3),
       ('ELÄKELÄINEN', 7.5, 3),
       ('AIKUINEN', 10, 4),
       ('LAPSI', 5, 4),
       ('ELÄKELÄINEN', 7.5, 4),
       ('AIKUINEN', 10, 5),
       ('LAPSI', 5, 5),
       ('ELÄKELÄINEN', 7.5, 5);

INSERT INTO kayttajat (kayttajanimi, salasana, etunimi, sukunimi, email, roolit, oikeudet)
VALUES ('myyja', '$2y$12$jYcrVgbM2tC0yfohkS5xxO1jGXSUdiLRzeTiJWnLxei7r4aErZ2Qa', 'Miia', 'Myyjä',
        'myyja@ticketguru.com', 'MYYJA', ''),
       ('esimies', '$2y$12$WbenBrwnCZKZOHLSQTjymOjZPvvspQ5c7BGk8izoASuLiQOrOD1o2', 'Ella', 'Esimies',
        'esimies@ticketguru.com', 'ESIMIES', ''),
       ('ovimies', '$2y$12$Z9OQ60AttYe5mtqRzklpeevm2kV6PO84H2HvV5DKkbzxA/wTAGzhO', 'Olli', 'Ovimies',
        'ovimies@ticketguru.com', 'OVIMIES', ''),
       ('myyja2', '$2y$12$jYcrVgbM2tC0yfohkS5xxO1jGXSUdiLRzeTiJWnLxei7r4aErZ2Qa', 'Mikko', 'Myyjä',
        'myyja2@ticketguru.com', 'MYYJA', ''),
       ('myyja3', '$2y$12$jYcrVgbM2tC0yfohkS5xxO1jGXSUdiLRzeTiJWnLxei7r4aErZ2Qa', 'Masi', 'Myyjä',
        'myyja3@ticketguru.com', 'MYYJA', '');

INSERT INTO tilaukset (kayttajaID, tila)
VALUES (1, 'KESKEN'),
       (2, 'KESKEN'),
       (3, 'KESKEN'),
       (3, 'KESKEN'),
       (2, 'KESKEN'),
       (1, 'KESKEN');

INSERT INTO liput (lippukategoriaID, tilausID, lippuhash)
VALUES (1, 1, UUID()),
       (1, 1, UUID()),
       (3, 1, UUID()),
       (2, 1, UUID()),
       (4, 2, UUID()),
       (4, 2, UUID()),
       (5, 2, UUID()),
       (5, 2, UUID()),
       (6, 2, UUID()),
       (4, 2, UUID()),
       (9, 3, UUID()),
       (7, 3, UUID()),
       (8, 3, UUID()),
       (10, 4, UUID()),
       (10, 4, UUID()),
       (11, 4, UUID()),
       (11, 4, UUID()),
       (12, 4, UUID()),
       (15, 4, UUID()),
       (13, 5, UUID());




