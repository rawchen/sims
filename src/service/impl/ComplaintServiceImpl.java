package service.impl;

import dao.ComplaintDao;
import dao.impl.ComplaintDaoImpl;
import domain.Complaint;
import service.ComplaintService;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService {
    private ComplaintDao dao = new ComplaintDaoImpl();

    @Override
    public List<Complaint> findAll() {
        return dao.findAllComplaint();
    }

    @Override
    public void addComplaint(Complaint complaint) {
        dao.addComplaint(complaint);
    }
}
