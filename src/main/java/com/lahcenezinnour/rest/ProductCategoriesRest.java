package com.lahcenezinnour.rest;

import com.lahcenezinnour.domain.ProductCategories;
import com.lahcenezinnour.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lahcen on 5/17/17.
 */
@RestController
@RequestMapping("/rest/category")
public class ProductCategoriesRest {

    @Autowired
    private ProductCategoriesService productCategoriesService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProductCategories>> all() {
        List<ProductCategories> productCategoriesList = productCategoriesService.findAll();

        if (productCategoriesList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else
            return new ResponseEntity<>(productCategoriesList, HttpStatus.OK);
    }

    @RequestMapping(value = "/gender/{gender}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductCategories>> getCategoriesByGender(@PathVariable String gender) {
        List<ProductCategories> productCategoriesList = productCategoriesService.getCategoriesByGender(gender);

        if (productCategoriesList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else
            return new ResponseEntity<>(productCategoriesList, HttpStatus.OK);
    }



}