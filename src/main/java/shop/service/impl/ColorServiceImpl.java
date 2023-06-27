package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.ColorDao;
import shop.entity.Color;
import shop.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorDao colorDao;
    @Override
    public Color save(Color color) {
        return colorDao.save(color);
    }

    @Override
    public Color get(Long id) {
        return colorDao.get(id);
    }

    @Override
    public Color remove(Color color) {
        return colorDao.remove(color);
    }
}
