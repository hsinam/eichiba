package com.eichiba.demo;

import com.eichiba.demo.entitys.Ingredient;
import com.eichiba.demo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	private IngredientsService ingredientsService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println(ingredientsService.getRecipeBasedOnIngredient(24).toString());
//	}
}
