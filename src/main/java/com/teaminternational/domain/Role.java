package com.teaminternational.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by pavel on 05.07.16.
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable{

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private long role_id;

    @Column(name = "name")
    private String name;

    public Role() {

    }

    public Role(long id, String name) {
        this.role_id = id;
        this.name = name;
    }

    public long getRoleId() {
        return role_id;
    }

    public void setRoleId(long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
