package ru.geekbrains.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private List<Product> products;


    @PostConstruct
    private void init(){
        products = new ArrayList<>();
    }

    public void addProductByID(Long id){
        products.add(productRepository.getProductById(id));
    }

    public void deleteProductByID(Long id){
        products.remove(productRepository.getProductById(id));
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
