package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Parti {

  @Id
  @Column
  private String partiBogstav;
  private String partiNavn;
  private String href;
  private int antalStemmer;

  //skal somehow connecte kandidater til? FK?

  public String getPartiNavn() {
    return partiNavn;
  }

  public void setPartiNavn(String partiNavn) {
    this.partiNavn = partiNavn;
  }

  public String getPartiBogstav() {
    return partiBogstav;
  }

  public void setPartiBogstav(String bogstav) {
    this.partiBogstav = bogstav;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  public int getAntalStemmer() {
    return antalStemmer;
  }

  public void setAntalStemmer(int antalStemmer) {
    this.antalStemmer = antalStemmer;
  }

}
