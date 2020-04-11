package cn.cstqb.exam.testmaker.actions.projects.current;

import cn.cstqb.exam.testmaker.actions.BaseAction;
import cn.cstqb.exam.testmaker.configuration.Constants;
import cn.cstqb.exam.testmaker.entities.*;
import cn.cstqb.exam.testmaker.services.IPaperQuestionService;
import cn.cstqb.exam.testmaker.services.IPaperService;
import cn.cstqb.exam.testmaker.services.IQuestionService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by 姜向阳
 * on 2020/4/9
 */
public class SavePaper extends BaseAction {
    //Ignore
    @Inject
    private IPaperService paperService;
    @Inject
    private IQuestionService questionService;
    @Inject
    private IPaperQuestionService paperQuestionService;
    private Paper paper;
    private String ids;


    @Override
    public void validateInput() {

    }

    //TODO
    @Override
    protected String executeImpl() throws Exception {
        logger.debug("SaveProjectQuestion.executeImpl: Saving question..." );
        /*
         * If the incoming question does not have project attribute, then it is a new entity,
         * attach current session project to it
         */
        logger.info(ids);
        Project project = (Project) session.get(Constants.ATTR_PROJECT);
        if (project == null) {
            addActionError(getText("error.user.auth.notLoggedIn"));
            return Constants.RESULT_USER_NOT_AUTHENTICATED;
        }
        int score = 0;
        String[] temp = ids.split("\\.");
        List<Question> questions = new ArrayList<>();
        logger.info(temp.length+" ");
        for (String idString : temp){
            Question question = questionService.findQuestion(Integer.parseInt(idString));
            questions.add(question);
            score += question.getScore();
            logger.info(idString);
            logger.info(question.getScore()+"    ");
        }

        paper.setScore(score);
        paper.setProject(project);
        paperService.save(paper);//save paper
        for (Question question : questions){//for each save paper question
            paperQuestionService.save(new PaperQuestion(paper, question));
        }
        return null;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }



    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public IQuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(IQuestionService questionService) {
        this.questionService = questionService;
    }

    public IPaperQuestionService getPaperQuestionService() {
        return paperQuestionService;
    }

    public void setPaperQuestionService(IPaperQuestionService paperQuestionService) {
        this.paperQuestionService = paperQuestionService;
    }
}
