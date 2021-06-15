# TicketGuru

Tiimi: Joonas Huttunen, Jussi Häyhä, Antti Jäppinen, Sasu Korhonen

## Johdanto


Projekti on harjoitustyö TicketGuru-lipunmyyntijärjestelmän luomiseksi. Asiakas on lipunmyyntitoimisto. Asiakkaan toiveena on järjestelmä, jossa tulee voida luoda tapahtumia, joihin voidaan myydä lippuja eri hintaluokissa sekä tulostaa lippuja, ja tarkastella myyntiraportteja tapahtumittain. 

Projekti toteutetaan palvelinpuolella Javalla Spring Boot ohjelmistokehyksessä, tietokantajärjestelmänä on MariaDB ja käyttöliittymä toteutetaan Reactilla. Projektin valmistuessa asiakkaalla on toimintavalmis myyntijärjestelmä, jossa yllä mainitut toiminnot on mahdollista toteuttaa. Rahaliikennettä ei tehtävän raameissa tarvitse järjestelmän sisään rakentaa. Järjestelmää käytetään ensisijaisesti tietokoneella, mutta lipuntarkastuksen voi tehdä myös mobiililaitteella. 


## Järjestelmän määrittely

### Roolit

Palvelinpuolella toimintoja on rajattu roolikohtaisesti.\
Samalla käyttäjällä voi olla useita rooleja.\
Toimintojen ja käyttäjäroolien yhteydet kuvataan alla.\
\
Käyttöliittymäpuolella on mahdollista toteuttaa sama siten, että raportteihin tai lipuntarkastukseen pääsee vain esimies tai ovimies, tarpeista riippuen.

#### Asiakas

Asiakas haluaa ostaa lipun päästäkseen tapahtumaan.\
Asiakas haluaa ostaa lipun joko ennakkoon tai ovella.\
\
Asiakkaalla ei ole palvelinpuolella roolia järjestelmään nähden.
#### Myyjä 
Myyjä haluaa myydä lipun asiakkaalle, suoriutuakseen työstään.\
Myyjä haluaa tietää, että paljonko tapahtumaan on lippuja jäljellä.\
Myyjä haluaa tulostaa tapahtumatyöntekijöitä varten ovelle myyntiin, liput, joita ei ole myyty ennakkoon.\
\
Myyjä kykenee tallentamaan uusia lippuja.\
Myyjä kykenee tallentamaan uusia tilauksia.\
\
Myyjä kykenee poistamaan olemassaolevia lippuja.\
Myyjä kykenee poistamaan olemassaolevia tilauksia.
#### Esimies
Esimies haluaa saada raportin myydyistä lipuista kehittääkseen liiketoimintaa.\
Esimies haluaa luoda uusia tapahtumia myyjiä ja asiakkaita varten.\
Esimies haluaa määritellä tapahtumille yksilölliset hinnat tapahtuman luonteen mukaan.\
\
Esimies kykenee tallentamaan uusia käyttäjiä.\
Esimies kykenee tallentamaan uusia lippukategorioita.\
Esimies kykenee tallentamaan uusia tapahtumapaikkoja.\
Esimies kykenee tallentamaan uusia tapahtumia.\
\
Esimies kykenee poistamaan olemassaolevia käyttäjiä.\
Esimies kykenee poistamaan olemassaolevia lippukategorioita.\
Esimies kykenee poistamaan olemassaolevia tapahtumapaikkoja.\
Esimies kykenee poistamaan olemassaolevia tapahtumia.
#### Ovimies 
Ovimies haluaa tarkistaa, että asiakkaan lippu on käyttämätön, hyödyntämällä yksilöllistä tunnistetta.\
Ovimies haluaa myydä ovella liput, joita ei ole myyty jo ennakkoon.
## Käyttöliittymä

Alustavaa hahmotelmaa käyttöliittymästä.

![Myyntitapahtuma](/img/myynti.JPG)
![Tapahtumat](/img/tapahtumat.JPG)
![Raportti](/img/raportti.JPG)


## Tietokanta

Ohessa kuvataan tietokannan taulut, kentät, ja tyypit.\
Taulun ohessa mainitaan myös muutoksien tekoon vaadittu rooli.

![Relaatiomalli](/img/relaatiomalli.jpg)

> ### _Kayttajat_
> _Käyttäjät-taulu sisältää käyttäjien tiedot. Käyttäjällä voi olla monta roolia ja oikeutta.\
> Esimies-rooli pystyy lisäämään ja poistamaan käyttäjiä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> kayttaja_ID | bigint(20) PK | käyttäjän id
> kayttajanimi | varchar(100) | käyttäjän kayttajanimi
> salasana | varchar(30) | käyttäjän salasana
> etunimi | varchar(50) | käyttäjän etunimi
> sukunimi | varchar(50) | käyttäjän sukunimi
> roolit | varchar(250) | käyttäjän roolit
> oikeudet | varchar(250) | käyttäjän oikeudet
> email | varchar(100) | käyttäjän sähköpostiosoite

> ### _Tapahtumat_
> _Tapahtumat-taulu sisältää tapahtumat. Tapahtumalla on yksi tapahtumapaikka.\
> Esimies-rooli pystyy lisäämään ja poistamaan tapahtumia._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtuma_ID | bigint(20) PK | tapahtuman id
> kuvaus | varchar(100) | tapahtuman kuvaus
> kapasiteetti | int(11) | tapahtuman maksimikapasiteetti (paljonko voidaan myydä lippuja)
> alkuaika | datetime | tapahtuman alkamisaika
> tapahtumapaikka_id | int FK | tapahtumapaikka, viittaus [tapahtumapaikka_id](#Tapahtumapaikat)-taulussa

> ### _Tapahtumapaikat_
> _Tapahtumapaikat-taulu sisältää tapahtumien sijainnit. Tapahtumapaikassa voi olla useita tapahtumia.\
> Esimies-rooli pystyy lisäämään ja poistamaan tapahtumapaikkoja._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtumapaikka_ID | int PK | tapahtumapaikan id
> tapahtumapaikka | varchar(100) | tapahtumapaikan nimi tai kuvaus
> osoite | varchar(100) | tapahtumapaikan osoite
> kapasiteetti | int(11) | tapahtumapaikan maksimikapasiteetti (paljonko mahtuu ihmisiä)
> puhelinnumero | varchar(50) | tapahtumapaikan puhelinnumero
> yhteyshenkilo | varchar(100) | tapahtumapaikan yhteyshenkilön nimi

> ### _Liput_ 
> _Liput-taulu sisältää yksittäisten lippujen tiedot. Lipulla on yksi lippukategoria.\
> Myyjä-rooli pystyy lisäämään ja poistamaan lippuja._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | bigint(20) PK | lipun id
> lippukategoria_id | bigint(20) FK | lippukategoria, viittaus [lippukategoria_id](#Lippukategoriat)-taulussa
> tilaus_id | bigint(20) | tilaus, viittaus [tilaus_id](#Tilaukset)-taulussa 
> lippuhash | varcahr(100) | UUID-joka säilötty merkkijonona
> kaytetty | datetime | Aikaleima, jolloin lippukäytetty. Oletusarvo null.

> ### _Lippukategoriat_ 
> _Lippukategoriat-taulu sisältää erilaiset lipputyypit.\
> Esimies-rooli pystyy lisäämään ja poistamaan lippukategorioita._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippukategoria_id | bigint(20) PK | lippukategorian id
> lippukategoria | varchar(100) | lippukategorian kuvaus (aikuinen, opiskelija, eläkeläinen, varusmies, jne)
> tapahtuma_id | bigint(20) fk | tapahtuma, viittaus [tapahtuma_id](#Tapahtumat)-taulussa
> hinta | double | lipun hinta lippukategorialle tapahtumassa

> ### _Tilaukset_ 
> _Tilaukset-taulu sisältää tilauksen tiedot. Tilauksella on tila, päivämäärä, loppusumma ja käyttäjä.\
> Myyjä-rooli pystyy lisäämään ja poistamaan tilauksia._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tilaus_id | bigint(20) | tilauksen id
> pvm | timestamp | tilauksen luontipäivä
> loppusumma | double | tilauksen loppusumma
> kayttaja_id | bigint(20) fk | käyttäjä, viittaus [kayttaja_id](#Kayttajat)-taulussa
> tila | enum['kesken', 'valmis', 'peruutettu'] | tilauksen tila


## Tekninen kuvaus

Järjestelmä on ensisijaisesti REST-API-palvelu, jonka avulla pystyy tuottamaan lipunmyyntijärjestelmän
verkkopalveluna. Rajapinta on dokumentoitu esimerkkeineen, sekä yleisimpine käyttötarkoituksineen.

Järjestelmän nykyisessä toimituksessa on käytetty MariaDB:tä tietokantajärjestelmänä, mutta vaihto esimerkiksi
PostgreSQL:n olisi täysin mahdollista tilauksesta.

Rajapinnan ja järjestelmän kasvaessa dokumentaatio eriytettiin omaksi repositoryksi. 

Rajapinnan tarkempi kuvaus löytyy erillisestä Github-repositorysta.  

https://github.com/jussihayha/TicketGuru-API


## Testaus

Järjestelmän testaus on toteutettu lähes täysin integraatiotestauksella.  
Testauksessa on huomioitu käyttäjätarinoiden erilaiset käyttötarpeet, ja käännetty ne testeiksi.

Integraatiotestauksen avulla pystymme simuloimaan sitä, että mitä käyttäjä tekisi järjestelmän kanssa. Integraatiotestauksen etuna on myös sen helppous. 

Testien mennessä läpi, integraatiotestauksella voi olettaa, että sovellus toimii halutusti.  
Toisaalta, mikäli testi ei mene läpi, niin se lähinnä kertoo, että joku asia ei toimi, mutta ei sen syvällisemmin, että mikä.

Unit-testaus mahdollistaa taas yksittäisten funktioiden ja toimintojen testaamisen.  
Tämän etuna on se, että ongelmatilanteessa saa paremman kuvan, että mikä on rikki, ja miksi.  
Unit-testien ongelmana on se, että vaikka kaikki testit menisivät läpi, se ei tarkoita, että sovellus toimisi.

Projektin aikana testaaminen osoittautui hankalimmaksi.  

IntelliJ IDEAssa suoritetut HTTP-kutsut, joilla integraatiotestausta suoritettiin löytyvät:  
 
[GET.http](src/test/java/com/Kineesio/TicketGuru/resources/GET.http)  
[POST.http](src/test/java/com/Kineesio/TicketGuru/resources/POST.http)

## Asennustiedot

### Kehitysympäristö

Kehitysympäristöä varten tämä repository tulee kloonata ja tuoda projektina valitsemaansa IDEen.
Kehitystiimi on käyttänyt sekä Eclipse IDEä, että IntelliJ IDEAa.

Paikallisen ympäristön asentamisen yhteydessä on suositeltava määritellä kehitysympäristöä varten oma, erillinen
tietokantapalvelin tai -palvelu.\
Tässä repositoryssa on käytössä MariaDB ja ilman erillistä konfiguraatiota, eivät
muut tietokantajärjestelmät välttämättä sovi. 

Tietokantaan liittyvät asetukset määritellään seuraavassa tiedostossa:   
[application.yml](src/main/resources/application.yml)

Dokumentaation ensimmäinen osa käsittelee tietokannan määrittelyä Spring Bootissa, toinen osa taulurakenteen luomista ja testidatan populointia.

Alla olevat asetukset tulee vastata paikallisen ympäristön porttia.  
URL-kenttään voi määritellä myös ulkoisen tietokannan, jos sellainen on käytettävissä.  

```MariaDB  
 spring:  
 datasource: 
    url: jdbc:mariadb://localhost:3306/<tietokannan nimi> 
    username: root 
    password: root  
    driverClassName: org.mariadb.jdbc.Driver 
```

```
PostgreSQL
spring: 
  datasource: 
    url: jdbc:postgresql://localhost:5432/<tietokannan nimi> 
    username: postgres 
    password: postgres  
    driverClassName: org.postgresql.Driver 
```

Yllä mainittujen lisäksi tulee varmistaa, että flyway-tietokantamigraatiota varten olevaa työkalua varten on määritetty tietokannan nimi schemas-määritykseen:

```
  flyway:
    schemas: <tietokannan nimi>
    baseline-on-migrate: true
    validate-on-migrate: false #true to populate local DB
    table: info
    enabled: true
```

Tietokantojen käyttäjätunnusmääritykset ja muut voi luvittaa haluamallaan tavalla. Järjestelmä kuitenkin vaatii, että se pystyy joko täysin hallinnoimaan yhtä tietokantaa, tai tarvittaessa luomaan sellaisen.

### Tietokannan luominen

Repositoryn master-haaran mukana tulee myös tietokannan luomiseen tarvittava init-skripta, sekä datan populointi.

Nämä määritellään seuraavissa tiedostoissa:  

Luominen  
[V1.0.0.__init.sql](src/main/resources/db/migration/V1.0.0__init.sql)  

Datan populointi  
[V2.0.0.__data.sql](src/main/resources/db/migration/V2.0.0__data.sql)  

### Tuotantoympäristö

Dokumentaatiossa ei erikseen anneta yksityiskohtaisia tietoja palvelun asentamisesta tuotantoon. Mikäli järjestelmän haluaa viedä tuotantoon, niin tulee kuitenkin seuraavat stepit suorittaa:

- Spring Boot sovellus tulee ylläpitää jossain (julkisesti tai lokaalisti, jos se vastaa käyttötarkoitusta)
- Tietokanta tulee ylläpitää jossain (julkisesti tai lokaalisti, jos se vastaa käyttötarkoitusta)

Käyttöönottoa varten voi Kineesiolta ostaa tarvittaessa lisäpalveluna asennuksen.

## Käynnistys- ja käyttöohje

Kineesio-ryhmän backend löytyy julkaistuna https://kineesio-ticketguru.herokuapp.com -osoitteesta. 

Haaga-Helia ammattikorkeakoulun Ohjelmistoprojekti 1 -kurssin opiskelijat tekivät oppilastyönä backendistä demon, jota voi testata seuraavassa osoitteessa:
https://kineesio-ticketguru-frontend.herokuapp.com

Opiskelijoiden tuottamaa clienttiä voi testata seuraavalla käyttäjätunnuksella:
Käyttäjätunnus : myyja
Salasana : myyja


# TicketGuru
