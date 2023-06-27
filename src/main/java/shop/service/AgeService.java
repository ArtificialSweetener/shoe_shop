package shop.service;

import shop.entity.Age;

public interface AgeService {
    Age save(Age age);
    Age get(Long id);
    Age remove(Age age);
}
