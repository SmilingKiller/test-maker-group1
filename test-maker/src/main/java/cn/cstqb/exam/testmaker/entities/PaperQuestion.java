package cn.cstqb.exam.testmaker.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * created by 姜向阳
 * on 2020/4/9
 */
@Entity
public class PaperQuestion extends AbstractBaseEntity{
    @ManyToOne
    @JoinColumn(name = "paper_id", nullable = false)
    private Paper paper;

    @OneToOne
    @JoinColumn(name = "paper_question_id", nullable = false)
    private Question question;

    public PaperQuestion(){
    }

    public PaperQuestion(Paper paper, Question question){
        this.paper = paper;
        this.question = question;
    }
    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
//    @Override
//    public int hashCode() {
//        return Objects.hashCode();
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
