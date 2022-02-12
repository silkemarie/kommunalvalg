package com.example.demo.repositories;

import com.example.demo.model.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KandidatRepository extends JpaRepository<Kandidat, String> {

  List<Kandidat> findKandidatByPartiBogstav(String partiBogstav);
}


