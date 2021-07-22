package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.services.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productType")
@CrossOrigin
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    /*
     * get all product type in database
     * @param Nothing
     * @return ResponseEntity<List<ProductType>>
     * */
    @GetMapping("/list")
    public ResponseEntity<List<ProductType>> getListProductType() {
        List<ProductType> productTypeList = this.productTypeService.findAll();
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }
}
