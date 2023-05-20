package com.example.recommendationservice.repository;

import com.example.recommendationservice.model.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {
    @Query("SELECT r FROM Recommandation r WHERE r.idproduit = :id")
    public List<Recommandation> findRecommandationsByIdproduit(@Param("id") Long id);

}
