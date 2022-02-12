package com.example.demo.config;


import com.example.demo.model.Kandidat;
import com.example.demo.repositories.KandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataKandidat implements CommandLineRunner {

  @Autowired
  KandidatRepository kandidatRepository;

  @Override
  public void run(String... args) throws Exception {
    Kandidat kandidat = new Kandidat();
    kandidat.setKandidatId("marcelmeijer");
    kandidat.setKandidatNavn("Marcel Meijer");
    kandidat.setPartiBogstav("A");
    kandidat.setHref("http://localhost:8080/kandidat/marcelmeijer");
    kandidat.setAntalPersonligeStemmer(0);
    kandidatRepository.save(kandidat);
  }
}


