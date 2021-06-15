package com.kineesio.TicketGuru.domain.repositories;

import com.kineesio.TicketGuru.domain.models.Tapahtumapaikka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "tapahtumapaikat", path = "tapahtumapaikat")

public interface TapahtumapaikkaRepository extends CrudRepository<Tapahtumapaikka, Long> {

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    Tapahtumapaikka save(Tapahtumapaikka tapahtumapaikka);

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    void delete(Tapahtumapaikka tapahtumapaikka);

}
