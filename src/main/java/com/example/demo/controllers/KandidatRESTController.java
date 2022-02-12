package com.example.demo.controllers;

import com.example.demo.model.Kandidat;
import com.example.demo.repositories.KandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class KandidatRESTController {

  @Autowired
  KandidatRepository kandidatRepository;


  @GetMapping("/kandidater")
  public List<Kandidat> getAllCandidates() {
    return kandidatRepository.findAll();
  }

  @GetMapping("/kandidat/{candidateId}")
  public Kandidat findCandidateById(@PathVariable String candidateId) {
    Optional<Kandidat> obj = kandidatRepository.findById(candidateId);
    if (obj.isPresent()) {
      return obj.get();
    } else {
      return null;
    }
  }

  @GetMapping("/kandidater/{partyId}")
  public List<Kandidat> getAllCandidatesByParty(@PathVariable String partyId) {
    return kandidatRepository.findKandidatByPartiBogstav(partyId);
  }


  @PostMapping("/kandidat")
  @ResponseStatus(HttpStatus.CREATED)
  public Kandidat postKandidat(@RequestBody Kandidat kandidat) {
    return kandidatRepository.save(kandidat);
  }

  @PutMapping("/kandidat/{candidateId}")
  public ResponseEntity<Kandidat> updateKandidat(@PathVariable String candidateId, @RequestBody Kandidat kandidat) {
    Optional<Kandidat> optKandidat = kandidatRepository.findById(candidateId);
    System.out.println(candidateId + " test af PUT");
    if (optKandidat.isPresent()) {
      kandidatRepository.save(kandidat); //her har vi opdateret vores database
      return new ResponseEntity<Kandidat>(kandidat, HttpStatus.OK);
    } else {
      Kandidat notfoundKandidat = new Kandidat();
      notfoundKandidat.setKandidatNavn("Jeg kunne ikke finde kandidaten " + candidateId);
      return new ResponseEntity<Kandidat>(notfoundKandidat, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/kandidat/{candidateId}")
  public ResponseEntity<String> deleteKandidat(@PathVariable String candidateId) {
    try {
      kandidatRepository.deleteById(candidateId);
      return new ResponseEntity<>("Slettet kandidat " + candidateId, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Jeg kunne ikke slette kandidat " + candidateId, HttpStatus.NOT_FOUND);
    }
  }

}

