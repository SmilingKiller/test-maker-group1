package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.PaperDao;
import cn.cstqb.exam.testmaker.entities.Paper;
import cn.cstqb.exam.testmaker.entities.Project;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MouFu Yan
 * Date: 2020/4/9
 * Time: 17:34
 */

public class PaperDaoImpl extends GenericJpaDaoImpl<Paper,Integer> implements PaperDao {
    @Override
    public List<Paper> findAll(Project project) {
        return findResultList("project", project);
    }

}
