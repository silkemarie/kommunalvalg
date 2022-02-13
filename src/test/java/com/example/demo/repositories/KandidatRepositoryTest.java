package com.example.demo.repositories;

import com.example.demo.model.Kandidat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KandidatRepositoryTest {

  @Autowired
  KandidatRepository kandidatRepository;

  @Test
  void testKandidatListe() {
    List<Kandidat> kandidatList = kandidatRepository.findAll();

    assertEquals(16, kandidatList.size());
  }

}
