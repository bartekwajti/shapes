package com.vaytee.shapes;

import com.vaytee.shapes.figures.model.Circle;
import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.figures.model.Rectangle;
import com.vaytee.shapes.figures.model.Square;
import com.vaytee.shapes.history.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

@EnableEntityLinks
@SpringBootApplication
public class ShapesApplication implements CommandLineRunner {

	@Autowired
	private FiguresRepository repository;

	@Autowired
	HistoryRepository historyRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShapesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		historyRepository.deleteAll();

		repository.deleteAll();

		repository.save(new Square(5));
		repository.save(new Square(6));
		repository.save(new Circle(4));
		repository.save(new Circle(10));

		repository.save(new Rectangle(5d, 10d));

		System.out.println("Figures found with findAll():");
		System.out.println("-------------------------------");
		for (Figure figure : repository.findAll()) {
			System.out.println(figure);
		}
		System.out.println();
	}
}
