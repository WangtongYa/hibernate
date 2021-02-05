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
        //��ò�ѯ����
        String lkm_name = request.getParameter("lkm_name");
        //�жϲ�ѯ������Ϊ��
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (lkm_name != null && !"".equals(lkm_name)) {
            //��Ϊ�գ���������ӽ�dc
            dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
        }
        //����������ѯ
        List<LinkMan> list = service.getAll(dc);
        //������Ž�request��
        request.setAttribute("list", list);
        //ת����ҳ��
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
