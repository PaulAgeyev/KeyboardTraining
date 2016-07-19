package com.teaminternational.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikitos on 18.07.2016.
 */

@Entity
@Table(name = "Moderator")
public class Moderator {


    @Id
    @Column(name = "moderator_id")
    @GeneratedValue
    private long moderator_id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "bug")
    private String bug;

    public Moderator(){}

    public Moderator(long moderator_id,  boolean status, String bug) {
        this.moderator_id = moderator_id;
        this.bug = bug;
        this.status = status;
    }

    public long getModerator_id() {
        return moderator_id;
    }

    public boolean isStatus() {
        return status;
    }

    public String getBug() {
        return bug;
    }

    public void setModerator_id(long moderator_id) {
        this.moderator_id = moderator_id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }

}
