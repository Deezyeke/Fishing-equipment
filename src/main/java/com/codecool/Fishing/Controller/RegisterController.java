package com.codecool.Fishing.Controller;

import com.codecool.Fishing.Model.Requests.RegisterRequest;
import com.codecool.Fishing.Service.FisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
@RequiredArgsConstructor
public class RegisterController {

    private FisherService fisherService;

    @PostMapping
    public void registerFisher(@RequestBody RegisterRequest request) throws IllegalArgumentException{
        if (fisherService.isRegistered(request)) {
            fisherService.registerFisher(request);
        } else {
            throw new IllegalArgumentException("Fishername or e-mail already used");
        }
        }
}
