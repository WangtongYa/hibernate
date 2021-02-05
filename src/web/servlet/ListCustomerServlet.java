package web.servlet;

import domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得查询条件
        String cust_name = request.getParameter("cust_name");
        //判断查询条件是否不为空
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (cust_name != null && !"".equals(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
        }//不为空，添加条件
        //调用service查询所有客户
        List<Customer> list = customerService.getAll(dc);
        //将客户列表放入request域
        request.setAttribute("list", list);
        //转发到页面
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
