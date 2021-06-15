package com.kineesio.TicketGuru.security;

import com.kineesio.TicketGuru.domain.models.Kayttaja;
import com.kineesio.TicketGuru.domain.repositories.KayttajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KayttajaDetailsService implements UserDetailsService {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Override
    public UserDetails loadUserByUsername(String kayttajanimi) {
        Kayttaja kayttaja = kayttajaRepository.findBykayttajanimi(kayttajanimi);
        if (kayttaja == null) {
            throw new UsernameNotFoundException(kayttajanimi);
        }
        return new KayttajaPrincipal(kayttaja);
    }
}