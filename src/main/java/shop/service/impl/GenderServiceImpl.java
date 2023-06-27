package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.GenderDao;
import shop.entity.Gender;
import shop.service.GenderService;
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderDao genderDao;

    @Override
    public Gender save(Gender gender) {
        return genderDao.save(gender);
    }

    @Override
    public Gender get(Long id) {
        return genderDao.get(id);
    }

    @Override
    public Gender remove(Gender gender) {
        return genderDao.remove(gender);
    }
}
