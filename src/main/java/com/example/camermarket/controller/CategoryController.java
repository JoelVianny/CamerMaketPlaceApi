package com.example.camermarket.controller;

import com.example.camermarket.entities.Category;
import com.example.camermarket.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/public/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategories(){
         return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable long id){
        return  categoryService.getCategory(id);
    }
    @PostMapping()
    public  Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public  Category edditCategory(@PathVariable long id , @RequestBody Category category){
        return  categoryService.editCategory(id, category);
    }
    @DeleteMapping("/{id}")
    public String  deleteCategory(@PathVariable long id){
        return  categoryService.deleteCategory(id);
    }



}
