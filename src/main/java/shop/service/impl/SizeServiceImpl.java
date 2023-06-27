package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.SizeDao;
import shop.entity.Size;
import shop.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeDao sizeDao;

    @Override
    public Size save(Size size) {
        return sizeDao.save(size);
    }

    @Override
    public Size get(Long id) {
        return sizeDao.get(id);
    }

    @Override
    public Size remove(Size size) {
        return sizeDao.remove(size);
    }
}
