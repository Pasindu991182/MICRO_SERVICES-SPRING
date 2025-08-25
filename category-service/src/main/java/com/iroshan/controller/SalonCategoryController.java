package com.iroshan.controller;

import com.iroshan.DTO.SalonDTO;
import com.iroshan.model.Category;
import com.iroshan.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category
    ){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);
        salonDTO.setName(category.getName());

        Category savedCategory = categoryService.saveCategory(category, salonDTO);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long id
    ) throws Exception {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(id);

        categoryService.deleteCategoryById(id,salonDTO.getId());
        return ResponseEntity.ok("Deleted");
    }
}
