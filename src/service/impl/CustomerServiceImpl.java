package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import service.CustomerService;
import utils.HibernateUtils;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        try {
            customerDao.save(c);
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        //提交事务
        tx.commit();

    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        List<Customer> list = null;
        try {
            list = customerDao.getAll();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        transaction.commit();
        return list;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        List<Customer> list = null;
        try {
            list = customerDao.getAll(dc);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        transaction.commit();
        return list;
    }


}
