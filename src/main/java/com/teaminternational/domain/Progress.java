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

    @Id
    @Column(name = "progress_id")
    @GeneratedValue
    private int progress_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "assigment_id")
    private Assigment assigment_id;

    @Column(name = "progress")
    private int progress;

    @Column(name = "error")
    private int error;

    @Column(name = "time")
    private Date time;

    public Progress(User user, Assigment assigment, int progress, int error, Date time) {
        this.user_id = user;
        this.assigment_id = assigment;
        this.progress = progress;
        this.error = error;
        this.time = time;
    }

    public int getId() {
        return progress_id;
    }

}
