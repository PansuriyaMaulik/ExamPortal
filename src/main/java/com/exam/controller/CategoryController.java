package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //Get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return this.categoryService.getCategory(categoryId);
    }

    //Get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    //delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId)
    {
        this.categoryService.deleteCategory(categoryId);
    }
}
