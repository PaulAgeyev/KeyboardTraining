package com.teaminternational.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pavel on 05.07.16.
 */

@Entity
@Table(name = "Progress")
public class Progress implements Serializable {

    //PROGRESS ID, ERROR, PROGRESS %,TIME, ASSIGMENT ID, USER_ID

    @Id
    @Column(name = "progress_id")
    @GeneratedValue
    private int progress_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment_id;

    @Column(name = "progress")
    private int progress;

    @Column(name = "error")
    private int error;

    @Column(name = "time")
    private int time;

    public Progress(){

    }

    public Progress(int id, User user, Assignment assignment, int progress, int error, int time) {
        this.progress_id = id;
        this.user_id = user;
        this.assignment_id = assignment;
        this.progress = progress;
        this.error = error;
        this.time = time;
    }

    public int getProgressId() {
        return progress_id;
    }

    public void setProgressId(int progress_id) {
        this.progress_id = progress_id;
    }

    public User getUserId() {
        return user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

    public Assignment getAssigmentId() {
        return assignment_id;
    }

    public void setAssigmentId(Assignment assigment_id) {
        this.assignment_id = assigment_id;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
