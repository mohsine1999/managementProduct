package com.example.recommendationservice;

import com.example.recommendationservice.model.Recommandation;
import com.example.recommendationservice.repository.RecommandationRepository;
import com.example.recommendationservice.service.RecommandationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RecommendationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendationServiceApplication.class, args);
	}
	//@Bean
	CommandLineRunner commandLineRunner(RecommandationRepository recommandationService,RecommandationRepository rp){
	return args -> {
//			int i=0;
//			List.of("mohsine","outman","rida").forEach(up->{
//				System.out.println(i);
//				Recommandation recommandation=new Recommandation();
//				recommandation.setAuthor(up);
//				recommandation.setRate((int)Math.random()*10);
//				recommandation.setSubject("rien");
//				recommandation.setContent("rein");
//				recommandation.setIdproduit(1L);
//				recommandationService.save(recommandation);
//			});
			List<Recommandation> recommandationList=recommandationService.findRecommandationsByIdproduit(1L);
			recommandationList.forEach(p->{
				System.out.println("hello");
				System.out.println(p.getIdproduit());
				System.out.println(p.getAuthor());
			});
		};
	}
}
