package com.kineesio.TicketGuru.domain.repositories;

import com.kineesio.TicketGuru.domain.models.Lippukategoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "lippukategoriat", path = "lippukategoriat")

public interface LippukategoriaRepository extends CrudRepository<Lippukategoria, Long> {

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    Lippukategoria save(Lippukategoria lippukategoria);

    @PreAuthorize("hasAuthority('ROLE_ESIMIES')")
    void delete(Lippukategoria lippukategoria);

}
