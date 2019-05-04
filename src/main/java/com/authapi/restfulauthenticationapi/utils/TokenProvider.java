package com.authapi.restfulauthenticationapi.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenProvider {

	private static String key = "SECRET_TOKEN";

    public static final String TOKEN_HEADER = "Authentication";

    public static String createToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public static Jws<Claims> decodeToken(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }
}
