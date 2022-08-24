package ru.geekbrains.spring1.lesson4.Repository;

import jakarta.transaction.NotSupportedException;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.Entities.Product;

import javax.annotation.PostConstruct;

import java.util.*;

@Repository
public class InMemoryRepository implements ProductDao {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Bread", 10),
                new Product(2l, "Milk", 20),
                new Product(3l, "Water", 30),
                new Product(4l, "Cheese", 10),
                new Product(5l, "Orange", 100)
        ));
    }

    @Override
    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product findById(Long id) {
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    @Override
    public void deleteById(Long id){
        Iterator<Product> iter = products.iterator();
        while (iter.hasNext()){
            Product p = iter.next();
            if (p.getId() == id){
                iter.remove();
            }
        }
    }

    @Override
    public Product saveOrUpdate(Product product) throws NotSupportedException {
        throw new NotSupportedException();
    }
}
