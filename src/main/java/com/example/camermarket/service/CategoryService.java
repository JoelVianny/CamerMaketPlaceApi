package com.example.camermarket.service;


import com.example.camermarket.entities.Category;
import com.example.camermarket.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private  final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return  categoryRepository.findAll();

    }

    public Category getCategory(long id){
        return  categoryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(" not found"));
    }


    public Category createCategory(Category category){
        return  categoryRepository.save(category);
    }

    public Category editCategory(long id, Category category){
        log.info(category.toString());

        Category foundCategory = getCategory(id);
        foundCategory.setName(category.getName());
        foundCategory.setParent(category.getParent());
        foundCategory.setChildren(category.getChildren());
        log.info(foundCategory.toString());
        return  categoryRepository.save(foundCategory);

    }

    public String deleteCategory(long id){
         categoryRepository.delete(getCategory(id));
         return  " category has deleted";
    }
}
