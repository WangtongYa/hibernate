package dao;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface AddLinkManDao {
    void addLinkMan(LinkMan linkMan);

    // ���Կ� ����ɫ����
    List<LinkMan> getAll(DetachedCriteria dc);
}
