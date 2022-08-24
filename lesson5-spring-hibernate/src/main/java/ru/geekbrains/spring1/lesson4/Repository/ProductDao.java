package ru.geekbrains.spring1.lesson4.Repository;

import jakarta.transaction.NotSupportedException;
import ru.geekbrains.spring1.lesson4.Entities.Product;


import java.util.List;

public interface ProductDao {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product) throws NotSupportedException;

}
