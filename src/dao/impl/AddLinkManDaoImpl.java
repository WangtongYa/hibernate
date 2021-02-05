package dao.impl;

import dao.AddLinkManDao;
import domain.LinkMan;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import utils.HibernateUtils;

import java.util.List;

public class AddLinkManDaoImpl implements AddLinkManDao {
    @Override
    public void addLinkMan(LinkMan linkMan) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(linkMan);
    }

    @Override
    public List<LinkMan> getAll(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        Criteria ec = dc.getExecutableCriteria(session);
        return ec.list();
    }
}
