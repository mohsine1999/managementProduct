package com.mosine.productcompositeservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recommandation {
    private Long idrecommandation;
    private String author;

    private String content;

    private String subject;

    private int   rate;
}
