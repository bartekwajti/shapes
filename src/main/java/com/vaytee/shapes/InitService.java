package com.vaytee.shapes;

import com.vaytee.shapes.figures.FiguresService;
import com.vaytee.shapes.figures.model.Circle;
import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.figures.model.Rectangle;
import com.vaytee.shapes.figures.model.Square;
import com.vaytee.shapes.history.HistoryService;
import com.vaytee.shapes.users.UserModelService;
import com.vaytee.shapes.users.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017-07-26.
 */
@Service
public class InitService {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FiguresService figuresService;

    @Autowired
    private UserModelService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        usersService.deleteAll();
        usersService.save(new UserModel("user", passwordEncoder.encode("pass"), authorities));
        usersService.save(new UserModel("user2", passwordEncoder.encode("pass"), authorities));

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

        historyService.save(
                historyService.createHistoryItemFromFigure(figuresService.findAll().get(0)));

        System.out.println("Figures found with findAll():");
        System.out.println("-------------------------------");
        figuresService.findAll().stream().forEach(f -> System.out.println(f));
        System.out.println();
    }
}
