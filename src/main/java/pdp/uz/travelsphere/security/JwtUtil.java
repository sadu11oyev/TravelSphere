package pdp.uz.travelsphere.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtUtil {
    private final CustomUserDetailService customUserDetailService;

    public String generateToken(String userName) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);

        String roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        System.out.println(roles);
        String jwts = Jwts.builder()
                .subject(userName)
                .issuer("travelSphere.uz")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))//7 kun
                .claim("roles", roles)
                .signWith(getKey())
                .compact();
        System.out.println(jwts);
        return jwts;
    }

    private SecretKey getKey() {
        StringBuilder value = getStringValueForSecretKey();
        byte[] bytes = Decoders.BASE64.decode(value.toString());
        return Keys.hmacShaKeyFor(bytes);
    }

    private static StringBuilder getStringValueForSecretKey() {
        StringBuilder value = new StringBuilder();
        value.append("1".repeat(64));
        return value;
    }

    public boolean isValid(String token) {
        getClaims(token);
        return true;
    }

    public String getUserName(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }


    public List<SimpleGrantedAuthority> getAuthorities(String token) {
        Claims claims = getClaims(token);
        String str = claims.get("roles", String.class);
        String[] arr= str.split(",");
        System.out.println(str);
        System.out.println(claims);
        return Arrays.stream(arr).map(SimpleGrantedAuthority::new).toList();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
