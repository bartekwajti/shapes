package com.vaytee.shapes;

import com.vaytee.shapes.figures.Circle;
import com.vaytee.shapes.figures.Figure;
import com.vaytee.shapes.figures.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShapesApplication implements CommandLineRunner {

	@Autowired
	private FiguresRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ShapesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		repository.save(new Square(5));
		repository.save(new Square(6));
		repository.save(new Circle(4));
		repository.save(new Circle(10));

		System.out.println("Figures found with findAll():");
		System.out.println("-------------------------------");
		for (Figure figure : repository.findAll()) {
			System.out.println(figure);
		}
		System.out.println();
	}
}
