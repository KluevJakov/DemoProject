package ru.jafix.studying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.studying.entities.Category;
import ru.jafix.studying.services.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    protected CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") UUID id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{categoryId}")
    public Boolean deleteCategory(@PathVariable("categoryId") UUID id) {
        try {
            categoryService.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping
    public Category editCategory(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
}
