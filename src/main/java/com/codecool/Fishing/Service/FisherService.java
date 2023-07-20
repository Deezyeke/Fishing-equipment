package com.codecool.Fishing.Service;

import com.codecool.Fishing.Model.Fisher;
import com.codecool.Fishing.Model.Repositories.FisherRepository;
import com.codecool.Fishing.Model.Requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FisherService {
    private FisherRepository fisherRepository;

    public void registerFisher(RegisterRequest request) {
        Fisher fisher = Fisher.builder()
                        .fisherName(request.getFisherName())
                        .email(request.getEmail())
                        .password(request.getPassword()).build();
        fisherRepository.save(fisher);
    }
}
