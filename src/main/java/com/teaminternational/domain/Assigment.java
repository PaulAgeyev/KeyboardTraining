package com.teaminternational.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pavel on 05.07.16.
 */
@Entity
@Table(name = "Assignment")
public class Assigment {

    @Id
    @Column(name = "assigment_id")
    @GeneratedValue
    private long assigment_id;

    @Column(name = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assigment_id")
    private Set<Progress> progressSet = new HashSet<Progress>();

    public Assigment(long id, String text) {
        this.assigment_id = id;
        this.text = text;
    }

    public long getId() {
        return assigment_id;
    }

    public void setId(long id) {
        this.assigment_id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
