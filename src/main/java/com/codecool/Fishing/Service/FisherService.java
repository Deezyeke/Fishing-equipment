package com.codecool.Fishing.Service;

import com.codecool.Fishing.Model.Fisher;
import com.codecool.Fishing.Model.Repositories.FisherRepository;
import com.codecool.Fishing.Model.Requests.LoginRequest;
import com.codecool.Fishing.Model.Requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public boolean isRegistered(RegisterRequest request) {
        return fisherRepository.findFisherByEmail(request.getEmail()) != null ||
                fisherRepository.findFisherByFisherName(request.getFisherName()) != null;
    }

    public Fisher login(LoginRequest request) {
        Fisher fisher = fisherRepository.findFisherByEmail(request.getEmail());
        if (fisher != null && fisher.getPassword().equals(request.getPassword())) {
            return fisher;
        } else {
            return null;
        }
    }
}
