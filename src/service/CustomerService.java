package service;

import domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
	//保存客户
	void save(Customer c);

    List<Customer> getAll();
//根据条件查询客户
    List<Customer> getAll(DetachedCriteria dc);
}
