package cn.cstqb.exam.testmaker.services.impl;

import cn.cstqb.exam.testmaker.dao.PaperDao;
import cn.cstqb.exam.testmaker.dao.PaperQuestionDao;
import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;
import cn.cstqb.exam.testmaker.services.IPaperQuestionService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class PaperQuestionServiceImpl implements IPaperQuestionService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private PaperQuestionDao paperQuestionDao;
    private PaperDao paperDao;

    @Inject
    public PaperQuestionServiceImpl(PaperQuestionDao paperQuestionDao,PaperDao paperDao){
        this.paperQuestionDao=paperQuestionDao;
        this.paperDao=paperDao;
    }

    @Override
    public void save(PaperQuestion paperQuestion) {
        Preconditions.checkArgument(paperQuestion != null,
                "Invalid question.");
        paperQuestionDao.create(paperQuestion);
    }

    @Override
    public List<PaperQuestion> findAll(Paper paper) {
        return paperQuestionDao.findResultList("paper",paper);
    }

    public List<PaperQuestion> findAll(int paperId){
        Preconditions.checkArgument(paperId>0);
        Paper paper = paperDao.findById(paperId);
        if (paper == null) {
            logger.error("PaperQuestionServiceImpl findAll(id): No paper found for ID: {}", paperId );
            return null;
        }
        return findAll(paper);
    }
}
