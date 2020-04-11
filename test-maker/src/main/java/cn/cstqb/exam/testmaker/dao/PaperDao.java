package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.Project;
import cn.cstqb.exam.testmaker.entities.Paper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MouFu Yan
 * Date: 2020/4/9
 * Time: 17:34
 */
public interface PaperDao extends GenericDao<Paper,Integer> {

    /**
     *
     * @param project
     * @return
     */
    List<Paper> findAll(Project project);
}
