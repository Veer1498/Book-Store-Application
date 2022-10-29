package com.bridgelabz.bookstoreapp.utilities;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Component
public class TokenUtil {
    private static final String SECRET="Veer";
    public String createToken(int empId)
    {
        String token= JWT.create().withClaim("id",empId).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public int decodeJWT(String jwt)
    {
        int id=0;
        if(jwt!=null)
        {
            id=JWT.require(Algorithm.HMAC256(SECRET)).build().verify(jwt).getClaim("id").asInt();
        }
        return id;
    }
}
