package ru.geekbrains.spring1.lesson4.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.Entities.Product;
import ru.geekbrains.spring1.lesson4.Repository.InMemoryRepository;
import ru.geekbrains.spring1.lesson4.Repository.MySqlRepository;
import ru.geekbrains.spring1.lesson4.Repository.ProductDao;

import java.util.List;

@Service
public class ProductService {

    private ProductDao mySqlRepository;

    @Autowired
    public void setProductRepository(MySqlRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }

    public List<Product> getAllProducts(){
        return mySqlRepository.findAll();
    }

    public Product findProductByID(Long id){
        return mySqlRepository.findById(id);
    }

    public void deleteProductById(Long id){
        mySqlRepository.deleteById(id);
    }

    public void changePrice(Long productId, Integer delta) {
        Product product = mySqlRepository.findById(productId);
        product.setPrice(product.getPrice() + delta);;
    }
}
