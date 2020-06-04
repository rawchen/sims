package service.impl;

import dao.PhotoDao;
import dao.impl.PhotoDaoImpl;
import domain.Photo;
import service.PhotoService;

public class PhotoServiceImpl implements PhotoService {
    private PhotoDao dao = new PhotoDaoImpl();

    @Override
    public void addPhoto(Photo photo) {
        dao.addPhoto(photo);
    }

    @Override
    public Photo findPhotoByPhotoId(String id) {
        return dao.findPhotoByPhotoId(id);
    }

    @Override
    public void updatePhoto(Photo photo) {
        dao.updatePhoto(photo);
    }
}
