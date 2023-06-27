package shop.dao;

import shop.entity.HeelHeight;

public interface HeelHeightDao {
    HeelHeight save(HeelHeight heelHeight);
    HeelHeight get(Long id);
    HeelHeight remove(HeelHeight heelHeight);
}
