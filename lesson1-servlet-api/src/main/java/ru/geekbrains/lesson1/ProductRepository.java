package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findByID(Long id){
        return productMap.get(id);
    }

    public void insert(Product p){
        Long id = identity.incrementAndGet();
        p.setId(id);
        productMap.put(id, p);
    }

    public void update(Product p){
        productMap.put(p.getId(), p);
    }

    public void remove(Product p){
        productMap.remove(p.getId());
    }
}
