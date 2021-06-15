package com.kineesio.TicketGuru.domain.repositories;


import com.kineesio.TicketGuru.domain.models.Tapahtuma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "tapahtumat", path = "tapahtumat")


public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long> {

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    Tapahtuma save(Tapahtuma tapahtuma);

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    void delete(Tapahtuma tapahtuma);


}
