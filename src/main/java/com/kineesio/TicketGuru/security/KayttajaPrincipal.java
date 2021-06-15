package com.kineesio.TicketGuru.security;

import com.kineesio.TicketGuru.domain.models.Kayttaja;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KayttajaPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Kayttaja kayttaja;

    public KayttajaPrincipal(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        this.kayttaja.haeOikeudet().forEach(o -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(o);
            authorities.add(authority);
        });

        this.kayttaja.haeRoolit().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        return authorities;
    }


    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return kayttaja.getSalasana();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return kayttaja.getKayttajanimi();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

}
