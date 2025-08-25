package com.iroshan.service.impl;

import com.iroshan.DTO.SalonDTO;
import com.iroshan.model.Category;
import com.iroshan.repository.CategoryRepository;
import com.iroshan.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceimpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(salonDTO.getId());
        newCategory.setImage(category.getImage());

        return  categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        
        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null) {
            throw new EntityNotFoundException("Category with id " + id + " not found");
        }
        return category;

    }



    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
        Category category = getCategoryById(id);
        if(category.getSalonId().equals(salonId)) {
            throw new Exception("Salon with id " + id + " not found");
        }
        categoryRepository.delete(category);
    }




}
