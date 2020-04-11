package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MouFu Yan
 * Date: 2020/4/9
 * Time: 17:34
 */
public interface PaperQuestionDao extends GenericDao<PaperQuestion, Integer> {

    /**
     * Finds all choices for the given question id
     * @param paperId
     * @return
     */
    List<PaperQuestion> findQuestion(int paperId);
}