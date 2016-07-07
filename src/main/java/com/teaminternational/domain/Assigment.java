package com.teaminternational.domain;

/**
 * Created by pavel on 05.07.16.
 */
public class Assigment {

    private int id_assignment;
    private int time;
    private int error;
    private String text;

    public int getId() {
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
