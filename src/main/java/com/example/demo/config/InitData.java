package com.example.demo.config;

import com.example.demo.model.Parti;
import com.example.demo.repositories.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class InitData implements CommandLineRunner {

  @Autowired
  PartiRepository partiRepository;

  @Override
  public void run(String... args) throws Exception {
    Parti parti1 = new Parti();
    parti1.setPartiBogstav("a");
    parti1.setPartiNavn("Socialdemokratiet");
    parti1.setHref("http://localhost:8080/parti/a");
    parti1.setAntalStemmer(0);
    partiRepository.save(parti1);
  }
}
