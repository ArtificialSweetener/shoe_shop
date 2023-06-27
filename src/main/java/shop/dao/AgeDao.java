package shop.dao;

import shop.entity.Age;

public interface AgeDao {
    Age save(Age age);
    Age get(Long id);
    Age remove(Age age);
}
