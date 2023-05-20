package com.mosine.productcompositeservice.models;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductComposite {
   private Product product;
   private List<Review> reviewList;
   private List<Recommandation> recommandationList;

}
