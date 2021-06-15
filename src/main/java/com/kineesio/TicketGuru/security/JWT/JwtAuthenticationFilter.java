package com.kineesio.TicketGuru.security.JWT;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kineesio.TicketGuru.domain.models.LoginViewModel;
import com.kineesio.TicketGuru.security.KayttajaPrincipal;
import net.minidev.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    // Yrittää autentikointia. Käytä LoginViewModelia mallina.
    // Onnistuessaan palauttaa käyttäjän tiedot ja oikeudet
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        LoginViewModel credentials = null;

        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();

        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(), credentials.getPassword(), new ArrayList<>());

        Authentication auth = authenticationManager.authenticate(authenticationToken);


        return auth;
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException {


        KayttajaPrincipal principal = (KayttajaPrincipal) authResult.getPrincipal();

        String token = JWT.create().withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
        // Lisää headeriin itse tokenin & responsebodyyn
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
        String responseBody = JwtProperties.HEADER_STRING + ", " + JwtProperties.TOKEN_PREFIX + token;


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        JSONObject json = new JSONObject();

        Date expirationDate = new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME);
        json.appendField("Authorization", token);
        json.appendField("ExpirationTime:", expirationDate.toString());

        out.print(json.toString());


    }
}