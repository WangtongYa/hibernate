package web.servlet;

import domain.Customer;
import org.apache.commons.beanutils.BeanUtils;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddCustomerServlet", urlPatterns = "/AddCustomerServlet")
public class AddCustomerServlet extends javax.servlet.http.HttpServlet {
    // ����һ��ҵ�� ������һ�컻���Ҿ�
    private CustomerService customerService  = new CustomerServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        //1.��ò�������װCustomer����
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.���ݵ�service��
        customerService.save(customer);

        response.sendRedirect(request.getContextPath()+"/customer/list.jsp");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
