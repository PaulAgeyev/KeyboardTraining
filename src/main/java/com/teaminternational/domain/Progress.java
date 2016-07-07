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
@Table(name = "tbl_progress")
public class Progress implements Serializable {

    @Id
    private int id_progress;
    @NotNull
    private String login;
    @NotNull
    private int id_assignment;
    @NotNull
    private int progress;

    public int getId_progress() {
        return id_progress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_assignment() {
        return id_assignment;
    }

    public void setId_assignment(int id_assignment) {
        this.id_assignment = id_assignment;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
