package com.example.recommendationservice.service;

import com.example.recommendationservice.model.Recommandation;

import java.util.List;

public interface RecommandationService {

    public Recommandation saveRecommandation(Recommandation recommandation);
    public Recommandation getRecommandation(Long id);
    public List<Recommandation> getByIdproduit(Long id);
    public List<Recommandation> getAllRecommandations();

    public void deleteRecommandation(Long id);

}
