/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lahcenezinnour.web;

import com.lahcenezinnour.domain.ProductCategories;
import com.lahcenezinnour.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author lahcene
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ProductCategoriesService productCategoriesService;
    
    @GetMapping(value = "/add")
    public String addGET() {
        return "category-editor";
    }

    @ModelAttribute("add")public String add(){return "Add new";}
    @ModelAttribute("genders")public String[] genders(){return new String[]{"MEN","WOMEN","KIDS"};}
    @ModelAttribute("category")public ProductCategories category(){return new ProductCategories();}
    @ModelAttribute("edit")public String edit(){return "Edit";}
    @ModelAttribute("categories")public List<ProductCategories> categories(){return productCategoriesService.findAll();}
    
    @PostMapping(value = "/add")
    public String addPOST(@Valid @ModelAttribute("category") ProductCategories category, BindingResult result) {
        productCategoriesService.save(category);
        return "redirect:all";
    }
    
    @GetMapping(value = "/update/{id}")
    public String updateGET(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        model.addAttribute("name", productCategoriesService.find(id).getCategoryName());
        return "category-editor";
    }
    
    @PostMapping(value = "/update/{id}")
    public String updatePOST(@PathVariable int id, @RequestParam(value="categoryName") String name) {
        productCategoriesService.update(id, name);
        return "redirect:../all";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String deletePOST(@PathVariable int id) {
        productCategoriesService.delete(productCategoriesService.find(id));
        return "redirect:../all";
    }
    
    @GetMapping(value = "/all")
    public String allGET() {
        return "categories-list";
    }
    
}
