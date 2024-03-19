package com.example.isyeriegitimi.service;

import com.example.isyeriegitimi.dto.UserDto;
import com.example.isyeriegitimi.dto.UserRequest;
import com.example.isyeriegitimi.dto.UserResponse;
import com.example.isyeriegitimi.model.Role;
import com.example.isyeriegitimi.model.User;
import com.example.isyeriegitimi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public UserResponse save(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nameSurname(userDto.getNameSurname())
                .role(Role.ADMIN).build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
    public UserResponse auth(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    public Optional<User> findById(int id) {
        return userRepository.findById((long)id);
    }

    public UserResponse updateUser(User users) {
        User user = User.builder()
                .username(users.getUsername())
                .password(passwordEncoder.encode(users.getPassword()))
                .nameSurname(users.getNameSurname())
                .role(Role.ADMIN).build();
        if(users.getUsername()!=null) user.setUsername(users.getUsername());
        if(users.getPassword()!=null) user.setPassword(users.getPassword());
        userRepository.save(users);
        System.out.println("Kullanıcı başarıyla güncellendi.");
        var token = jwtService.generateToken(users);
        return UserResponse.builder().token(token).build();
    }
    public void deleteUser(int id) {

        User user=userRepository.findById((long) id).orElse(null);

        if(user != null){
            userRepository.deleteById(user.getId());
            var token = jwtService.generateToken(user);
            UserResponse.builder().token(token).build();
            System.out.println("Kullanıcı başarıyla silindi.");
        }else{
            System.out.println("Hata");
        }
    }
}

