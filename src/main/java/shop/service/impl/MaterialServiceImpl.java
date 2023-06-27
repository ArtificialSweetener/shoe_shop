package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.MaterialDao;
import shop.entity.Material;
import shop.service.MaterialService;
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialDao materialDao;
    @Override
    public Material save(Material material) {
        return materialDao.save(material);
    }

    @Override
    public Material get(Long id) {
        return materialDao.get(id);
    }

    @Override
    public Material remove(Material material) {
        return materialDao.remove(material);
    }
}
