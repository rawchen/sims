package service;

import domain.Notify;

import java.util.List;

/**
 * 公告的业务接口
 */
public interface NotifyService {
    /**
     * 公告发布
     */
    void addNotify(Notify notify);

    List<Notify> find();

    List<Notify> findAll();

    void deleteNotifyById(String notifyid);


}
