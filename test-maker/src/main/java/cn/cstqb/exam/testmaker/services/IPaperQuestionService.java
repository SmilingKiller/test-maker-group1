package cn.cstqb.exam.testmaker.services;

import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;

import java.util.List;

public interface IPaperQuestionService {
    void save(PaperQuestion paperQuestion);
    List<PaperQuestion> findAll(Paper paper);
    List<PaperQuestion> findAll(int paperId);
}
