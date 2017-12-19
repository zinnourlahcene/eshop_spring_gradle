/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lahcenezinnour.web;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lahcenezinnour.domain.*;
import com.lahcenezinnour.service.OptionsService;
import com.lahcenezinnour.service.ProductCategoriesService;
import com.lahcenezinnour.service.ProductService;
import com.lahcenezinnour.service.SubProductCategoriesService;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lahcene
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoriesService categoryService;
    @Autowired
    private SubProductCategoriesService subctegoryService;
    @Autowired
    private OptionsService optionsService;

    private static int id;
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dzs9bzpgu",
            "api_key", "381291291516977",
            "api_secret", "BEZ-DDTrTZPXQv63vjyqP2iptmE"));

    @GetMapping(value = "/add")
    public String addGET() {
        return "product-editor";
    }

    @PostMapping(value = "/add")
    public String addPOST(@ModelAttribute("product") Products product,
                          @RequestParam(value = "optionsBrand", required = false, defaultValue = "0") Integer optionsBrand,
                          @RequestParam(value = "optionsSize", required = false) List<Integer> optionsSize,
                          @RequestParam(value = "optionsColor", required = false) List<Integer> optionsColor,
                          @RequestParam(value = "optionsGender", defaultValue = "0", required = false) Integer optionsGender,
                          @RequestParam("Image") MultipartFile file) throws IOException {

        File f= Files.createTempFile("temp", file.getOriginalFilename()).toFile();
        file.transferTo(f);
        Map response=cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
        JSONObject json=new JSONObject(response);
        String url=json.getString("url");

        product.setProductImage(url);
        List<ProductOptions> productoptions = new ArrayList<>();

        productoptions.add(new ProductOptions(3, product, optionsService.find(optionsBrand)));
        for (int i = 0; i < optionsSize.size(); i++) {
            productoptions.add(new ProductOptions(2, product, optionsService.find(optionsSize.get(i))));
        }
        for (int i = 0; i < optionsColor.size(); i++) {
            productoptions.add(new ProductOptions(1, product, optionsService.find(optionsColor.get(i))));
        }
        productoptions.add(new ProductOptions(4, product, optionsService.find(optionsGender)));

        product.setProductOptionsByProductId(productoptions);
        productService.save(product);

        return "redirect:all";
    }

    @GetMapping(value = "/update/{id}")
    public String updateGET(Model model, @PathVariable int id) {
        System.out.println("+++++++++++++++ updateGET +++++++++++");
        Integer optionsGender= null, optionsBrand= null;List<Integer> optionsSize = new ArrayList<>();List<Integer> optionsColor = new ArrayList<>();

        for (int i = 0; i <  productService.find(id).getProductOptionsByProductId().size(); i++) {
            if (productService.find(id).getProductOptionsByProductId().get(i).getOptionGroupId() == 1){
                optionsColor.add(productService.find(id).getProductOptionsByProductId().get(i).getOptionsByOptionId().getOptionId());
            }else if (productService.find(id).getProductOptionsByProductId().get(i).getOptionGroupId() == 2){
                optionsSize.add(productService.find(id).getProductOptionsByProductId().get(i).getOptionsByOptionId().getOptionId());
            }else if (productService.find(id).getProductOptionsByProductId().get(i).getOptionGroupId() == 3){
                optionsBrand = productService.find(id).getProductOptionsByProductId().get(i).getOptionsByOptionId().getOptionId();
            }else{
                optionsGender = productService.find(id).getProductOptionsByProductId().get(i).getOptionsByOptionId().getOptionId();
            }
        }

        model.addAttribute("id", id);
        model.addAttribute("product", productService.find(id));
        model.addAttribute("brandById", optionsBrand);
        model.addAttribute("size", optionsSize);
        model.addAttribute("color", optionsColor);
        model.addAttribute("genderById", optionsGender);

        System.out.println(optionsGender);
        System.out.println(optionsBrand);
        System.out.println(optionsColor);
        System.out.println(optionsSize);

        return "product-editor";
    }

    @PostMapping(value = "/update")
    public String updatePOST(@ModelAttribute("product") Products product) {
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping(value = "/all")
    public String allGET() {
        return "products-list";
    }

    @ModelAttribute("categories")List<ProductCategories> categories(){return categoryService.findAll();}
    @ModelAttribute("product")public Products product(){return new Products();}
    @ModelAttribute("products")public List<Products> products(){return productService.findAll();}
    @ModelAttribute("optionsBrand")public Integer optionsBrand(){return new Integer(0);}
    @ModelAttribute("optionsGender")public Integer optionsGender(){return new Integer(0);}
    @ModelAttribute("optionsSize")public List<Integer> optionsSize(){return new ArrayList<>();}
    @ModelAttribute("optionsColor")public List<Integer> optionsColor(){return new ArrayList<>();}
    @ModelAttribute("subcategories")public List<SubProductCategories> subcategories(){return subctegoryService.findAll();}
    @ModelAttribute("add")public String add(){return "Add new";}
    @ModelAttribute("edit")public String edit(){return "Edit";}
    @ModelAttribute("ActivityName")public Products.ActivityName[] ActivityName(){return Products.ActivityName.values();}
    @ModelAttribute("ActivityDisplay")public Products.ActivityDisplay[] ActivityDisplay(){return Products.ActivityDisplay.values();}
    @ModelAttribute("genders")public List<Options> genders(){return optionsService.getAllByGroupName("gender");}
    @ModelAttribute("colors")public List<Options> colors(){return optionsService.getAllByGroupName("color");}
    @ModelAttribute("sizes")public List<Options> sizes(){return optionsService.getAllByGroupName("size");}
    @ModelAttribute("brands")public List<Options> brands(){return optionsService.getAllByGroupName("brand");}
}
