package com.teaminternational.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by pavel on 05.07.16.
 */
@Entity
@Table(name = "tbl_roles")
public class Role implements Serializable{

    @Id
    private long id_role;
    @NotNull
    private String name;

    public long getRole() {
        return id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
