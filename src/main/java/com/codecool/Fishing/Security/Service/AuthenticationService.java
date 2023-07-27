package com.codecool.Fishing.Security.Service;

import com.codecool.Fishing.Model.Fisher;
import com.codecool.Fishing.Model.Repositories.FisherRepository;
import com.codecool.Fishing.Model.Requests.RegisterRequest;
import com.codecool.Fishing.Security.Request.AuthenticationRequest;
import com.codecool.Fishing.Security.Response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final FisherRepository fisherRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {
        Fisher fisher = Fisher.builder()
                .fisherName(request.getFisherName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        fisherRepository.save(fisher);
        return "Successful registration!";
    }

    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getFisherName(), request.getPassword()));
        UserDetails userDetails = fisherRepository.findFisherByFisherName(request.getFisherName())
                .orElseThrow(()-> new UsernameNotFoundException("Username not found!"));
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
