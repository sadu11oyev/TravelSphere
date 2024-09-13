package pdp.uz.travelsphere.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pdp.uz.travelsphere.dto.ChangePasswordDto;
import pdp.uz.travelsphere.dto.LoginDto;
import pdp.uz.travelsphere.dto.RegisterDto;
import pdp.uz.travelsphere.entity.User;
import pdp.uz.travelsphere.mappers.UserMapper;
import pdp.uz.travelsphere.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterDto registerDto) {
        User user = userMapper.registerDtoToEntity(registerDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user.getUsername();
    }

    public String login(LoginDto loginDto) {
        User user = userMapper.loginDtoToEntity(loginDto);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email or password", e);
        }
        return user.getUsername();
    }

    public String changePassword(ChangePasswordDto changePasswordDto) {
        LoginDto loginDto = new LoginDto(changePasswordDto.username(),changePasswordDto.oldPassword());
        String userName = login(loginDto);
        User user = userRepository.findByUsername(userName);
        user.setPassword(passwordEncoder.encode(changePasswordDto.newPassword()));
        userRepository.save(user);
        return user.getUsername();
    }
}
