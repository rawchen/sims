package dao.impl;

import dao.NotifyDao;
import domain.Notify;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class NotifyDaoImpl implements NotifyDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Notify notify) {
        try {
            String sql = "insert into notify(notifyDate,notifyInfo) values(?,?)";
            template.update(sql,notify.getNotifyDate(),notify.getNotifyInfo());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notify> findAllNotify() {
        try {
            String sql = "select * from notify order by id DESC";
            List<Notify> notifys = template.query(sql, new BeanPropertyRowMapper<Notify>(Notify.class));
            return notifys;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteNotifyById(String notifyid) {
        try {
            String sql = "delete from notify where id=?";
            template.update(sql,notifyid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notify> findNotify() {
        try {
            String sql = "select * from notify order by id DESC limit 3";
            List<Notify> notify = template.query(sql, new BeanPropertyRowMapper<Notify>(Notify.class));
            return notify;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
