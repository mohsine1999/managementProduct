package com.mosine.productcompositeservice.ClientFeign;


import com.mosine.productcompositeservice.models.Recommandation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "recommandation-service")
public interface RecommandationFeign {
    @GetMapping("/api/recommandations/produit/{id}")
    public List<Recommandation> getByIdproduit(@PathVariable Long id);
}
