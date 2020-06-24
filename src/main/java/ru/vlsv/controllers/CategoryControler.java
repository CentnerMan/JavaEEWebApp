package ru.vlsv.controllers;

import ru.vlsv.entity.Category;
import ru.vlsv.entity.Product;
import ru.vlsv.services.CategoryService;
import ru.vlsv.services.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.06.2020
 * @link https://github.com/Centnerman
 */

@Named
@SessionScoped
public class CategoryControler implements Serializable {

    @Inject
    private CategoryService categoryService;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String createCategory() {
        this.category = new Category();
        return "/category.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category)  {
        categoryService.delete(category.getId());
    }

    public String saveCategory()  {
        if (category.getId() == null) {
            categoryService.insert(category);
        } else {
            categoryService.update(category);
        }
        return "/categories.xhtml?faces-redirect=true";
    }
}
