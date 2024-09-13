package pdp.uz.travelsphere.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.travelsphere.dto.ChangePasswordDto;
import pdp.uz.travelsphere.dto.LoginDto;
import pdp.uz.travelsphere.dto.RegisterDto;
import pdp.uz.travelsphere.security.JwtUtil;
import pdp.uz.travelsphere.security.Response;
import pdp.uz.travelsphere.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @Tag(name = "Register user")
    @Transactional
    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto registerDto) {
        String userName=authService.register(registerDto);
        return ResponseEntity.ok(
                Response.builder().message("Token").data("Bearer " + jwtUtil.generateToken(userName)).build()
        );
    }

    @Tag(name = "Login user")
    @Transactional
    @SneakyThrows
    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto) {
        String userName=authService.login(loginDto);
        return ResponseEntity.ok(
                Response.builder().message("Token").data("Bearer " + jwtUtil.generateToken(userName)).build()
        );
    }

    @Tag(name = "Change password")
    @Transactional
    @SneakyThrows
    @PostMapping("/changePassword")
    public HttpEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto){
        String userName = authService.changePassword(changePasswordDto);
        return ResponseEntity.ok(
                Response.builder().message("Password changed successfully").data(userName).build()
        );
    }

}
