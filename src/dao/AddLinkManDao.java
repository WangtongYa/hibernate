package dao;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface AddLinkManDao {
    void addLinkMan(LinkMan linkMan);

    // 试试看 看颜色变了
    List<LinkMan> getAll(DetachedCriteria dc);
}
