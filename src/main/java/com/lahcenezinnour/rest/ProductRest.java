package com.lahcenezinnour.rest;

import com.lahcenezinnour.domain.Products;
import com.lahcenezinnour.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lahcen on 4/21/17.
 */
@RestController
@RequestMapping("/rest/product")
public class ProductRest {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all", produces = "application/json")
    public @ResponseBody List<Products> all() {
        return productService.findAll();
    }

    @GetMapping(value = "/range", params = {"page", "items", "activity"}, produces = "application/json")
    public @ResponseBody ResponseEntity<List<Products>> getProductsByRange_MainActivity(@RequestParam int page, @RequestParam int items, @RequestParam String activity) {
        List<Products> productsList = productService.findByProductActivityName(page, items, activity);
        if (productsList.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(productsList, HttpStatus.OK);

    }


}
