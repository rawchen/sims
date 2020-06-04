package dao.impl;

import dao.PhotoDao;
import domain.Photo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class PhotoDaoImpl implements PhotoDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addPhoto(Photo photo) {
        try {
            String sql = "insert into photo(photo_id,photo_name) values(?,?)";
            template.update(sql,photo.getPhotoId(),photo.getPhotoName());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Photo findPhotoByPhotoId(String id) {
        try {
            String sql = "select * from photo where photo_id = ?";
            Photo photo = template.queryForObject(sql,new BeanPropertyRowMapper<Photo>(Photo.class),id);
            return photo;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePhoto(Photo photo) {
        try {
            String sql = "update photo set photo_name=? where photo_id=?";
            template.update(sql,photo.getPhotoName(),photo.getPhotoId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
