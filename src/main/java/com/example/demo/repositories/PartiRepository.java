package com.example.demo.repositories;

import com.example.demo.model.Parti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartiRepository extends JpaRepository<Parti, String> {
}
