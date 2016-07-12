package com.teaminternational.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by pavel on 05.07.16.
 */

@Entity
@Table(name = "User")
public class User implements Serializable{

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private long user_id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public User(){

    }

    public User(long id, String login, String password, String firstName, String lastName, Role role_id) {
        this.user_id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role_id = role_id;
    }

    public long getId() {
        return user_id;
    }

    public void setId(long id) {
        this.user_id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getIdRole() {
        return role_id;
    }

    public void setIdRole(Role id_role) {
        this.role_id = id_role;
    }
}
