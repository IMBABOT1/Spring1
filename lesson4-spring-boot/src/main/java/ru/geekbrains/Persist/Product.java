package ru.geekbrains.Persist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Product {

    private Long id;

    @NotBlank(message = "can not be empty!!!")
    private String title;

    @Min(1)
    private Integer minPrice;

    @Max(1000)
    private Integer maxPrice;

    public Product(Long id, String title, Integer minPrice, Integer maxPrice) {
        this.id = id;
        this.title = title;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return id + " " + title + " " + minPrice + " " + maxPrice;
    }

}