package com.kineesio.TicketGuru.domain.repositories;


import com.kineesio.TicketGuru.domain.models.Tilaus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "tilaukset", path = "tilaukset")

public interface TilausRepository extends CrudRepository<Tilaus, Long> {

    @PreAuthorize("hasAuthority('ROLE_MYYJA')")
    Tilaus save(Tilaus tilaus);

    @PreAuthorize("hasAuthority('ROLE_MYYJA')")
    void delete(Tilaus tilaus);

}