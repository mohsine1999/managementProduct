package com.mosine.productcompositeservice.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Long idproduit;

    private String name;

    private double weight;
}
