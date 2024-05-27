package com.security.jwt.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.security.jwt.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	private static String secret_key = "sha";
	private static long exp_dur = 1 * 60 * 1000;

	public String generateUtils(User user) {
		Long currentMill = System.currentTimeMillis();
		Long expMilli = currentMill+ exp_dur;
		Date date = new Date();
		Date exp = new Date(expMilli);
		//claims
		Claims claims = Jwts.claims()
				.setIssuer(user.getId().toString())
				.setIssuedAt(date)
				.setExpiration(exp);
		
		claims.put("email", user.getEmail());
		claims.put("username", user.getUsername());
		//generate token
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, this.secret_key.getBytes())
				.compact();

	}
}
