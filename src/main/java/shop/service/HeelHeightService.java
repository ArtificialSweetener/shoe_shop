package shop.service;

import shop.entity.HeelHeight;

public interface HeelHeightService {
    HeelHeight save(HeelHeight heelHeight);
    HeelHeight get(Long id);
    HeelHeight remove(HeelHeight heelHeight);
}
