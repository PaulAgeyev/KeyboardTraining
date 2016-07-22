package com.teaminternational.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Created by pavel on 05.07.16.
 */
@Entity
@Table(name = "Assignment")
public class Assignment {

    @Id
    @Column(name = "assignment_id")
    @GeneratedValue
    private long assignment_id;

    @Column(name = "text")
    @Length(max = 900)
    private String text;

    @Column(name = "lesson")
    private int lesson;

    @Column(name = "nameLesson")
    private String nameLesson;


    @Transient
    private List<Progress> progress ;

    public List<Progress> getProgress() {
        return progress;
    }

    public void setProgress( List<Progress> progress) {
        this.progress = progress;
    }



    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "assignment_id")
    private Set<Progress> progressSet = new HashSet<Progress>();


    public Assignment() {}

    public Assignment(long id, String text, int lesson, String nameLesson) {
        this.assignment_id = id;
        this.text = text;
        this.lesson = lesson;
        this.nameLesson = nameLesson;
    }

    public long getId() {
        return assignment_id;
    }

    public void setId(long id) {
        this.assignment_id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLesson() {return lesson;}

    public void setLesson(int lesson) {this.lesson = lesson;}

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }
}