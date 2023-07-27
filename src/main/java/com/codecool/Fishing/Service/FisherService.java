package com.codecool.Fishing.Service;

import com.codecool.Fishing.Model.Fisher;
import com.codecool.Fishing.Model.Repositories.FisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FisherService {
    private FisherRepository fisherRepository;

    public Fisher getFisher(String fisherName) {
        return fisherRepository.findFisherByFisherName(fisherName)
                .orElse(null);
    }
}
