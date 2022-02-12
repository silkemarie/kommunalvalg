package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kandidat {

  @Id
  @Column
  private String kandidatId;
  private String kandidatNavn;
  private String href;
  private String partiBogstav;
  private int antalPersonligeStemmer;

  public String getKandidatId() {
    return kandidatId;
  }

  public void setKandidatId(String kandidatId) {
    this.kandidatId = kandidatId;
  }

  public String getKandidatNavn() {
    return kandidatNavn;
  }

  public void setKandidatNavn(String kandidatNavn) {
    this.kandidatNavn = kandidatNavn;
  }

  public String getPartiBogstav() {
    return partiBogstav;
  }

  public void setPartiBogstav(String partiBogstav) {
    this.partiBogstav = partiBogstav;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  public int getAntalPersonligeStemmer() {
    return antalPersonligeStemmer;
  }

  public void setAntalPersonligeStemmer(int antalPersonligeStemmer) {
    this.antalPersonligeStemmer = antalPersonligeStemmer;
  }

}