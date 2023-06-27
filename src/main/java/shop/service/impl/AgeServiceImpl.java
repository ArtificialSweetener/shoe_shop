package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.AgeDao;
import shop.entity.Age;
import shop.service.AgeService;
@Service
public class AgeServiceImpl implements AgeService {
    @Autowired
    private AgeDao ageDao;
    @Override
    public Age save(Age age) {
        return ageDao.save(age);
    }

    @Override
    public Age get(Long id) {
        return ageDao.get(id);
    }

    @Override
    public Age remove(Age age) {
        return ageDao.remove(age);
    }
}
