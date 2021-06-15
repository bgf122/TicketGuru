package com.kineesio.TicketGuru.domain.repositories;

import com.kineesio.TicketGuru.domain.models.Kayttaja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "kayttajat", path = "kayttajat")

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {

    Kayttaja findBykayttajanimi(String kayttajanimi);

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    Kayttaja save(Kayttaja kayttaja);

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    void delete(Kayttaja kayttaja);

}
