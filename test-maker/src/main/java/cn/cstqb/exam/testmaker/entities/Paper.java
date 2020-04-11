package cn.cstqb.exam.testmaker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * created by 姜向阳
 * on 2020/4/9
 */
@Entity
public class Paper extends AbstractBaseEntity{

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private String paper_name;
    @Column(nullable = false)
    private String description;

    public Paper(){
    }
    public Paper(Project project){
        this.project = project;
    }
    public Paper(Project project, User author){
        this.project = project;
        this.author = author;
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(author, project, score);
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public boolean validate() {
//        return super.validate();
//    }

}
