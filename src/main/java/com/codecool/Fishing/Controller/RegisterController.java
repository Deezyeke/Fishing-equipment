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
    public void registerFisher(@RequestBody RegisterRequest request) {
        fisherService.registerFisher(request);
    }
}
