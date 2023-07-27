package com.codecool.Fishing.Controller;

import com.codecool.Fishing.Security.Request.RegisterRequest;
import com.codecool.Fishing.Security.Service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
@AllArgsConstructor
public class RegisterController {

    private AuthenticationService authenticationService;

    @PostMapping
    public String registerFisher(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }
}
