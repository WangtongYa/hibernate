package web.servlet;

import domain.LinkMan;
import org.apache.commons.beanutils.BeanUtils;
import service.AddLinkManService;
import service.impl.AddLinkManServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddLinkManServlet", urlPatterns = "/AddLinkManServlet")
public class AddLinkManServlet extends HttpServlet {
    private AddLinkManService service = new AddLinkManServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkMan linkMan = new LinkMan();
        try {
            BeanUtils.populate(linkMan, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        service.addLinkMan(linkMan);
        System.out.println(linkMan.getLkm_name());
        response.sendRedirect(request.getContextPath()+"/jsp/linkman/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
