package com.example.recommendationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Recommandation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idrecommandation;
    private String author;

    private String content;

    private String subject;

    private int   rate;
    private Long idproduit;
}
