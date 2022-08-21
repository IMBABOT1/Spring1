package ru.geekbrains.Persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final Map<Long, Product> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product(1l, "first", 10));
        this.insert(new Product(2l, "second", 20));
        this.insert(new Product(3l, "third", 30));
        this.insert(new Product(4l, "fourth", 40));
        this.insert(new Product(5l, "fifth", 50));
    }

    public List<Product> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public Product findById(long id) {
        return userMap.get(id);
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        userMap.put(id, product);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        userMap.put(product.getId(), product);
        return product;
    }

    public void delete(long id) {
        userMap.remove(id);
    }

}