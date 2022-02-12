package com.example.demo.controllers;

import com.example.demo.model.Parti;
import com.example.demo.repositories.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PartiRESTController {

  @Autowired
  PartiRepository partiRepository;

  @GetMapping("/")
    public String index() {
    return "Instruktioner for at stemme her i guess?";
    }

  @GetMapping("/partier")
  public List<Parti> getAllParties() {
    return partiRepository.findAll();
  }

  @GetMapping("/parti/{partyId}")
  public Parti findPartyById(@PathVariable String partyId) {
    Optional<Parti> obj = partiRepository.findById(partyId);
    if (obj.isPresent()) {
      return obj.get();
    } else {
      return null;
    }
  }

  @PostMapping("/parti")
  @ResponseStatus(HttpStatus.CREATED)
  public Parti postParty(@RequestBody Parti parti) {
    return partiRepository.save(parti);
  }

  @PutMapping("/parti/{partyId}")
  public ResponseEntity<Parti> updateParty(@PathVariable String partyId, @RequestBody Parti parti) {
    Optional<Parti> optParti = partiRepository.findById(partyId);
    if (optParti.isPresent()) {
      partiRepository.save(parti); //her har vi opdateret vores database
      return new ResponseEntity<Parti>(parti, HttpStatus.OK);
    } else {
      Parti notfoundParti = new Parti();
      notfoundParti.setPartiBogstav("Jeg kunne ikke finde partiet " + partyId);
      return new ResponseEntity<Parti>(notfoundParti, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/parti/{partyId}")
  public ResponseEntity<String> deleteParti(@PathVariable String partyId) {
    try {
      partiRepository.deleteById(partyId);
      return new ResponseEntity<>("Slettet parti " + partyId, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Jeg kunne ikke slette parti " + partyId, HttpStatus.NOT_FOUND);
    }
  }

}
