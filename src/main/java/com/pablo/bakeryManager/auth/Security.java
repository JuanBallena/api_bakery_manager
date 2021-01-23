package com.pablo.bakeryManager.auth;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.apache.commons.codec.digest.DigestUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Security {

	private static final int MINUTES_SESSION = 720;
	private static final String PREFIX_TOKEN = "Bearer ";
	
	public static String toMd5(String originalText) {
		
		return DigestUtils.md5Hex(originalText).toUpperCase();
	}
	
	public static String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + MINUTES_SESSION * 60 * 1000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return PREFIX_TOKEN + token;
	}
	
}
