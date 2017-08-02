package com.vaytee.shapes.users.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by Admin on 2017-07-31.
 */
@Document
@Getter
public class UserModel {

    @Id
    private String id;

    @Getter
    @Setter
    @Indexed(unique = true)
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    List<GrantedAuthority> authorities;

    public UserModel(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


}
