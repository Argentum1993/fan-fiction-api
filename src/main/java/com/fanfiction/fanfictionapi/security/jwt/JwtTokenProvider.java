package com.fanfiction.fanfictionapi.security.jwt;

import static org.springframework.util.StringUtils.hasText;

import com.fanfiction.fanfictionapi.security.JwtUserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  private final UserDetailsService userDetailsService;

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private long validityInMilliseconds;

  @Value("${jwt.header}")
  private String authorizationHeader;

  @Autowired
  public JwtTokenProvider(
      @Qualifier("JwtUserDetailsServiceImpl") JwtUserDetailsServiceImpl jwtUserDetailsService) {
    this.userDetailsService = jwtUserDetailsService;
  }

  @PostConstruct
  protected void init(){
    secret = Base64.getEncoder().encodeToString(secret.getBytes());
  }

  public String createToken(String email){
    Claims claims = Jwts.claims().setSubject(email);
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public String resolveToken(HttpServletRequest request){
    String bearer = request.getHeader(authorizationHeader);
    if (hasText(bearer) && bearer.startsWith("Bearer ")){
      return bearer.substring(7);
    }
    return null;
  }

  public boolean validateToken(String token){
    try {
      Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(getEmail(token));
      return !claimsJws.getBody().getExpiration().before(new Date()) && userDetails.isEnabled();
    } catch (JwtException | IllegalArgumentException | UsernameNotFoundException e){
      throw new JwtAuthenticationException(
          "JWT token is expired or invalid", HttpStatus.UNAUTHORIZED);
    }
  }

  public Authentication getAuthentication(String token){
    try {
      UserDetails userDetails = userDetailsService.loadUserByUsername(getEmail(token));
      return new UsernamePasswordAuthenticationToken(
          userDetails, "", userDetails.getAuthorities());
    } catch (UsernameNotFoundException e) {
      throw new JwtAuthenticationException("User not found");
    }
  }

  public String getEmail(String token){
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }
}
