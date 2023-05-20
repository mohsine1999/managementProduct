package com.mosine.productservice;

import com.mosine.productservice.model.Product;
import com.mosine.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

   // @Bean
  CommandLineRunner commandLineRunner(ProductRepository productRepo){
        return  args -> {
            List.of("hpp","acer","tinkpad").forEach(elt->{
                Product product=new Product();
                product.setName(elt);
                product.setWeight(2);
                productRepo.save(product);
            });
        }   ;
    }
}
