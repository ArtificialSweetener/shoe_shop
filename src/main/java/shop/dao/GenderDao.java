package shop.dao;

import shop.entity.Gender;

public interface GenderDao {
    Gender save(Gender gender);
    Gender get(Long id);
    Gender remove(Gender gender);
}
