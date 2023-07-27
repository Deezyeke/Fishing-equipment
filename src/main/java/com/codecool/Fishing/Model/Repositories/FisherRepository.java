package com.codecool.Fishing.Model.Repositories;

import com.codecool.Fishing.Model.Fisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FisherRepository extends JpaRepository<Fisher, Long> {
     Fisher findFisherById(Long id);
     Fisher findFisherByEmail(String email);

     Optional<Fisher> findFisherByFisherName(String fisherName);
}
