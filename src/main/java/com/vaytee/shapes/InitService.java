package com.vaytee.shapes;

import com.vaytee.shapes.figures.FiguresService;
import com.vaytee.shapes.figures.model.Circle;
import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.figures.model.Rectangle;
import com.vaytee.shapes.figures.model.Square;
import com.vaytee.shapes.history.HistoryService;
import com.vaytee.shapes.users.UsersService;
import com.vaytee.shapes.users.model.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 2017-07-26.
 */
@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE, onConstructor = @__(@Autowired))
public class InitService {

    @NonNull
    HistoryService historyService;

    @NonNull
    FiguresService figuresService;

    @NonNull
    UsersService usersService;

    @NonNull
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        usersService.deleteAll();
        usersService.save(new User("user", passwordEncoder.encode("pass"), authorities));
        usersService.save(new User("user2", passwordEncoder.encode("pass"), authorities));

        historyService.deleteAll();

        figuresService.deleteAll();

        figuresService.save(new Square(5d));
        figuresService.save(new Square(6d));
        figuresService.save(new Circle(4d));
        figuresService.save(new Circle(10d));

        figuresService.save(new Rectangle(5d, 10d));

        Figure rect = new Rectangle(5d, 20d);
        rect.setUser("user2");
        figuresService.save(rect);

        historyService.createAndSaveHistoryRecord(figuresService.findAll().get(0));

        System.out.println("Figures found with findAll():");
        System.out.println("-------------------------------");
        figuresService.findAll().stream().forEach(f -> System.out.println(f));
        System.out.println();
    }
}
