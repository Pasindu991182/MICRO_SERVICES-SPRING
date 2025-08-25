package com.iroshan.repository;

import com.iroshan.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Set<Category> findBySalonId(Long salonId);
}
