package cn.cstqb.exam.testmaker.services.impl;

import cn.cstqb.exam.testmaker.dao.PaperDao;
import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.PaperQuestion;
import cn.cstqb.exam.testmaker.entities.Project;
import cn.cstqb.exam.testmaker.services.IPaperService;
import cn.cstqb.exam.testmaker.services.IProjectService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class PaperServiceImpl implements IPaperService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private IProjectService projectService;
    private PaperDao dao;
    @Inject
    public PaperServiceImpl(IProjectService projectService,PaperDao dao) {
        this.projectService=projectService;
        this.dao=dao;
    }

    @Override
    public void save(Paper paper) {
        if(paper==null){
            if (logger.isDebugEnabled()) {
                logger.debug("Paper is null. Operation aborted.");
            }
            return;
        }
        dao.create(paper);
    }

    @Override
    public List<Paper> findAll(Project project) {
           return dao.findAll(project);
    }

    @Override
    public List<Paper> findAll(String projectName) {
        checkArgument(!Strings.isNullOrEmpty(projectName));
        Project project = projectService.find(projectName);
        return findAll(project);
    }

    @Override
    public List<Paper> findAll(Project project, int pageSize, int pageNumber) {
        checkArgument(project != null);
        checkArgument(pageSize > 1, "Page size must be greater than 1.");
        checkArgument(pageNumber > 0);
        return dao.findResultList("project", project, pageSize, pageNumber);
    }

    @Override
    public Paper find(int id) {
        return dao.findById(id);
    }

}
