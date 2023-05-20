package com.mosine.productcompositeservice.controller;


import com.mosine.productcompositeservice.ClientFeign.ProductFeign;
import com.mosine.productcompositeservice.ClientFeign.RecommandationFeign;
import com.mosine.productcompositeservice.ClientFeign.ReviewFeign;
import com.mosine.productcompositeservice.models.Product;
import com.mosine.productcompositeservice.models.ProductComposite;
import com.mosine.productcompositeservice.models.Recommandation;
import com.mosine.productcompositeservice.models.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/productComposites")
public class ProductCompositeController {

    private final ProductFeign productFeign;
    private final RecommandationFeign recommandationFeign;
    private final ReviewFeign reviewFeign;
     // Methode generale  permet de consulter tous les informations sur un produit
    @GetMapping("/{id}")
    public ProductComposite productComposite(@PathVariable Long id){
        ProductComposite composite=new ProductComposite();
        composite.setProduct(productFeign.getProduct(id));
        List<Recommandation> recommandationList=recommandationFeign.getByIdproduit(id);
        composite.setRecommandationList(recommandationList);
        List<Review> listReview=reviewFeign.findReviewByIdproduct(id);
        composite.setReviewList(listReview);
        return composite;
    }
    @GetMapping("/prduit/{id}")
    public Product getProduct(@PathVariable Long id){
        return productFeign.getProduct(id);
    }
    @GetMapping("/review/{id}")
    public List<Review> getreview(@PathVariable Long id){
        return reviewFeign.findReviewByIdproduct(id);
    }
    @GetMapping("/recommandation/{id}")
    public List<Recommandation> getreco(@PathVariable Long id){
        List<Recommandation> recommandationList=recommandationFeign.getByIdproduit(id);
        recommandationList.forEach(p-> System.out.println(p.getAuthor()));
        return recommandationList;
    }

    @GetMapping("/teste")
    public String teste(){
        return "succes";
    }
    @GetMapping("/saveproduct")
    public Product saveProduct(@RequestBody Product product){
        return productFeign.saveProduct(product);
    }
}
