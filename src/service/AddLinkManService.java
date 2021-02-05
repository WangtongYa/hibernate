package service;

import domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface AddLinkManService {
    void addLinkMan(LinkMan linkMan);

    List<LinkMan> getAll(DetachedCriteria dc);
}
