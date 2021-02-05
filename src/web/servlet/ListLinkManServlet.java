package web.servlet;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.AddLinkManService;
import service.impl.AddLinkManServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.List;

@WebServlet(name = "ListLinkManServlet", urlPatterns = "/ListLinkManServlet")
public class ListLinkManServlet extends HttpServlet {
    private AddLinkManService service = new AddLinkManServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得查询条件
        String lkm_name = request.getParameter("lkm_name");
        //判断查询条件不为空
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (lkm_name != null && !"".equals(lkm_name)) {
            //不为空，将条件添加进dc
            dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
        }
        //根据条件查询
        List<LinkMan> list = service.getAll(dc);
        //将结果放进request域
        request.setAttribute("list", list);
        //转发到页面
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
