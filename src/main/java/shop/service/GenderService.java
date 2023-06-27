package shop.service;

import shop.entity.Gender;

public interface GenderService {
    Gender save(Gender gender);
    Gender get(Long id);
    Gender remove(Gender gender);
}
