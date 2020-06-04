package service.impl;

import dao.CDCDao;
import dao.impl.CDCDaoImpl;
import domain.CDC;
import service.CDCService;

import java.util.List;

public class CDCServiceImpl implements CDCService {
    private CDCDao dao = new CDCDaoImpl();

    @Override
    public List<CDC> findAllCollege() {
        return dao.findAllCollege();
    }

    @Override
    public List<CDC> findAllDepartment() {
        return dao.findAllDepartment();
    }

    @Override
    public List<CDC> findAllClass() {
        return dao.findAllClass();
    }

    @Override
    public List<CDC> findAll() {
        return dao.findAll();
    }
}
