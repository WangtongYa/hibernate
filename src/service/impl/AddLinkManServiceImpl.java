package service.impl;

import dao.AddLinkManDao;
import dao.CustomerDao;
import dao.impl.AddLinkManDaoImpl;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import service.AddLinkManService;
import utils.HibernateUtils;

import java.util.List;

public class AddLinkManServiceImpl implements AddLinkManService {
    private CustomerDao cd = new CustomerDaoImpl();
    private AddLinkManDao dao = new AddLinkManDaoImpl();

    @Override
    public void addLinkMan(LinkMan linkMan) {
        HibernateUtils.getCurrentSession().beginTransaction();
        try {
            Long cust_id = linkMan.getCust_id();
            Customer customer = cd.getById(cust_id);
            linkMan.setCustomer(customer);
            dao.addLinkMan(linkMan);
        } catch (Exception e) {
            HibernateUtils.getCurrentSession().beginTransaction().rollback();
            e.printStackTrace();
        }
        HibernateUtils.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public List<LinkMan> getAll(DetachedCriteria dc) {
        HibernateUtils.getCurrentSession().beginTransaction();
        List<LinkMan> list = null;
        try {
            list = dao.getAll(dc);
        } catch (Exception e) {
            HibernateUtils.getCurrentSession().beginTransaction().rollback();
            e.printStackTrace();
        }
        HibernateUtils.getCurrentSession().beginTransaction().commit();
        return list;

    }
}
