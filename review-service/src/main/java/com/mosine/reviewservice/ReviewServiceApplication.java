package com.mosine.reviewservice;

import com.mosine.reviewservice.model.Review;
import com.mosine.reviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}
	//@Bean
	CommandLineRunner commandLineRunner(ReviewRepository reviewRepository){
		return args ->{
			List.of("re1","rev2","REv3").forEach(rv->{
				Review review=new Review();
				review.setSubject("pas de subjects");
				review.setIdproduct(1L);
				review.setContent("pas de contenu");
				review.setAuthor("inconnu");


			});
			List<Review> reviews=reviewRepository.findByIdproduct(1L);
			reviews.forEach(pr->{
				System.out.println(pr.getAuthor());
			});
		};
	}

}
