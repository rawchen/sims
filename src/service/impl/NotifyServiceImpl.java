package service.impl;

import dao.NotifyDao;
import dao.impl.NotifyDaoImpl;
import domain.Notify;
import service.NotifyService;

import java.util.List;

public class NotifyServiceImpl implements NotifyService {
    private NotifyDao dao = new NotifyDaoImpl();

    @Override
    public void addNotify(Notify notify) {
        dao.add(notify);
    }

    @Override
    public List<Notify> find() {
        return dao.findNotify();
    }

    @Override
    public List<Notify> findAll() {
        return dao.findAllNotify();
    }

    @Override
    public void deleteNotifyById(String notifyid) {
        dao.deleteNotifyById(notifyid);
    }
}
