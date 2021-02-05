package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import utils.HibernateUtils;

import java.util.List;


public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        return list;
    }

    @Override
    public Customer getById(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        Customer customer = session.get(Customer.class, cust_id);
        return customer;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        //将离线对象关联到session
        Criteria ec = dc.getExecutableCriteria(session);
        return ec.list();
    }
}
