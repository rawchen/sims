package dao.impl;

import dao.ComplaintDao;
import domain.Complaint;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ComplaintDaoImpl implements ComplaintDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Complaint> findAllComplaint() {
        try {
            String sql = "select * from complaint order by id DESC";
            List<Complaint> complaints = template.query(sql, new BeanPropertyRowMapper<Complaint>(Complaint.class));
            return complaints;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addComplaint(Complaint complaint) {
        try {
            String sql = "insert into complaint(cdate,content) values(?,?)";
            template.update(sql,complaint.getCdate(),complaint.getContent());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
