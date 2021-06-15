package com.kineesio.TicketGuru.security.JWT;

public class JwtProperties {
    public static final String SECRET = "KineesioTicket";
    public static final int EXPIRATION_TIME = 36000000; // 1 tunti 3600000, 10 tuntia 36000000
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}