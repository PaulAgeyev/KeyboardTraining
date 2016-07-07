package com.teaminternational.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by pavel on 05.07.16.
 */

@Entity
@Table(name = "tbl_users")
public class User implements Serializable{

    @Id
    private long id;
    @NotNull
    private String login;
    @NotNull
    private int id_role;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    public User(long id,String login, int id_role, String password, String firstName, String lastName) {
        this.login = login;
        this.id_role = id_role;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId_role(int id_role) {this.id_role=id_role; }

    public int getId_role() {return id_role; }

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
}
