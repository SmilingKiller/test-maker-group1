package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.PaperQuestionDao;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MouFu Yan
 * Date: 2020/4/9
 * Time: 17:34
 */

public class PaperQuestionDaoImpl extends GenericJpaDaoImpl<PaperQuestion,Integer> implements PaperQuestionDao {

    @Override
    public List<PaperQuestion> findQuestion(int paperId) {
        EntityManager em=provider.get();
        return em.createQuery("SELECT c FROM PaperQuestion c WHERE c.question.id = :paperId", PaperQuestion.class)
                .setParameter("paperId", paperId)
                .getResultList();
    }
}
