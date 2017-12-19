/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lahcenezinnour.web;

import com.lahcenezinnour.domain.SubProductCategories;
import com.lahcenezinnour.service.ProductCategoriesService;
import com.lahcenezinnour.service.SubProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 *
 * @author lahcene
 */
@Controller
@RequestMapping(value = "/subcategory")
public class SubcategoryController {
    @Autowired
    private SubProductCategoriesService subProductCategoriesService;
    @Autowired
    private ProductCategoriesService productCategoriesService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGET(Model model) {
        System.out.println("+++++++++++++++ addGET +++++++++++");
        model.addAttribute("add", "Add new");
        model.addAttribute("productCategories", productCategoriesService.findAll());
        model.addAttribute("addSubcategory", new SubProductCategories());
        return "subcategory-editor";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPOST(@Valid @ModelAttribute("addSubcategory") SubProductCategories subcategory, Model model, BindingResult result) {
        System.out.println("+++++++++++++++ addPOST +++++++++++");
        System.out.println("+++++++++++++++"+ subcategory.getSubCategoryName());
        subProductCategoriesService.save(subcategory);
        return "redirect:all";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateGET(Model model, @PathVariable int id) {
        System.out.println("+++++++++++++++ updateGET +++++++++++");
        model.addAttribute("id", id);
        model.addAttribute("edit", "Edit");
        model.addAttribute("idCategory", subProductCategoriesService.find(id).getProductCategoriesByCategoryId().getCategoryId());
        model.addAttribute("addSubcategory", subProductCategoriesService.find(id));
        model.addAttribute("productCategories", productCategoriesService.findAll());
        return "subcategory-editor";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatePOST(@PathVariable int id, @ModelAttribute(value="addSubcategory") SubProductCategories subProductCategories) {
        SubProductCategories s = subProductCategoriesService.find(id);
        s.setSubCategoryName(subProductCategories.getSubCategoryName());
        s.setProductCategoriesByCategoryId(subProductCategories.getProductCategoriesByCategoryId());
        subProductCategoriesService.saveAndFlush(s);
        return "redirect:../all";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePOST(Model model, @PathVariable int id) {
        System.out.println("+++++++++++++++ deletePOST +++++++++++");
        subProductCategoriesService.delete(subProductCategoriesService.find(id));
        return "redirect:../all";
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allGET(Model model) {
        System.out.println("+++++++++++++++ allGET +++++++++++");
        model.addAttribute("subcategories", subProductCategoriesService.findAll());
        
        return "subcategories-list";
    }
    
}
