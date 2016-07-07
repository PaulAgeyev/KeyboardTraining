package com.teaminternational.domain;

/**
 * Created by pavel on 05.07.16.
 */
public class Progress {

    private int id_progress;
    private String login;
    private int id_assignment;
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
