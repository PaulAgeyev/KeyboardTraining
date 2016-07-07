package com.teaminternational.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by pavel on 05.07.16.
 */
@Entity
@Table(name = "tbl_assignments")
public class Assigment {

    @Id
    private long id_assignment;
    @NotNull
    private int time;
    @NotNull
    private int error;
    @NotNull
    private String text;

    public long getId() {
        return id_assignment;
    }

    public void setId(int id) {
        this.id_assignment = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
