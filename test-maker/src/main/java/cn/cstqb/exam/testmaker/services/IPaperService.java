package cn.cstqb.exam.testmaker.services;

import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;
import cn.cstqb.exam.testmaker.entities.Project;
import cn.cstqb.exam.testmaker.entities.Question;

import java.util.List;

public interface IPaperService {
    void save(Paper paper);
    List<Paper> findAll(Project project);
    List<Paper> findAll(String projectName);
    /**
     *
     * @param project
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<Paper> findAll(Project project, int pageSize, int pageNumber);
    Paper find(int id);
}
