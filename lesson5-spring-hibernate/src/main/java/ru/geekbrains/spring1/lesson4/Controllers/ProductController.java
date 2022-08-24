package ru.geekbrains.spring1.lesson4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.Entities.Product;
import ru.geekbrains.spring1.lesson4.Services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }


    @GetMapping("/products/change_price")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }

}

