package com.kineesio.TicketGuru.domain.repositories;

import com.kineesio.TicketGuru.domain.models.Lippu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@RepositoryRestResource(collectionResourceRel = "liput", path = "liput")

public interface LippuRepository extends CrudRepository<Lippu, Long> {

    @PreAuthorize("hasAuthority('ROLE_MYYJA')")
    Lippu save(Lippu lippu);

    @PreAuthorize("hasAuthority('ROLE_MYYJA')")
    void delete(Lippu lippu);

    Lippu findBylippuhash(String lippuhash);


}