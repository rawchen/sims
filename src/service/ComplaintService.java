package service;

import domain.Complaint;

import java.util.List;

/**
 * 小吐槽的业务接口
 */
public interface ComplaintService {
    List<Complaint> findAll();

    void addComplaint(Complaint complaint);
}
