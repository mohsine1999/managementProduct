package com.example.recommendationservice.controller;


import com.example.recommendationservice.model.Recommandation;
import com.example.recommendationservice.service.RecommandationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommandations")
public class RecommandationController {
    private final RecommandationService recommandationService;

    @PostMapping
    public Recommandation saveRecommandation(@RequestBody Recommandation recommandation) {
        return recommandationService.saveRecommandation(recommandation);
    }
    @GetMapping("/produit/{id}")
    public List<Recommandation> getByIdproduit(@PathVariable Long id){
        return  recommandationService.getByIdproduit(id);
    }
    @GetMapping("/{idRecommandation}")
    public Recommandation getRecommandation(@PathVariable Long idRecommandation) {
        return recommandationService.getRecommandation(idRecommandation);
    }

    @GetMapping
    public List<Recommandation> getAllRecommandations() {
        return recommandationService.getAllRecommandations();
    }

    @DeleteMapping
    public void deleteRecommandation(@PathVariable Long idRecommandation) {
        recommandationService.deleteRecommandation(idRecommandation);
    }
}
