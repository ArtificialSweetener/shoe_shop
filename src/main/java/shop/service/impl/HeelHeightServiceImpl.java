package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.HeelHeightDao;
import shop.entity.HeelHeight;
import shop.service.HeelHeightService;
@Service
public class HeelHeightServiceImpl implements HeelHeightService {
    @Autowired
    private HeelHeightDao heelHeightDao;
    @Override
    public HeelHeight save(HeelHeight heelHeight) {
        return heelHeightDao.save(heelHeight);
    }

    @Override
    public HeelHeight get(Long id) {
        return heelHeightDao.get(id);
    }

    @Override
    public HeelHeight remove(HeelHeight heelHeight) {
        return heelHeightDao.remove(heelHeight);
    }
}
