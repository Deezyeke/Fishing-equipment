package com.codecool.Fishing.Controller;

import com.codecool.Fishing.Model.Fisher;
import com.codecool.Fishing.Security.Request.AuthenticationRequest;
import com.codecool.Fishing.Security.Response.AuthResponse;
import com.codecool.Fishing.Security.Service.AuthenticationService;
import com.codecool.Fishing.Security.Service.JwtService;
import com.codecool.Fishing.Service.FisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class LoginController {
    private final FisherService fisherService;
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/api/get-me")
    public Fisher getMe(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) {
        String token = header.substring(7);
        String userName = jwtService.extractUsername(token);
        return fisherService.getFisher(userName);
    }
}
