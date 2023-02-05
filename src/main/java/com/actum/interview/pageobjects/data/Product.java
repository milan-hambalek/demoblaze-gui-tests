package com.actum.interview.pageobjects.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Product {

    public static List<Product> phones() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Product.class.getResourceAsStream("/products/phones.json"), Product[].class));
    }

    public static List<Product> laptops() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Product.class.getResourceAsStream("/products/laptops.json"), Product[].class));
    }

    public static List<Product> monitors() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Product.class.getResourceAsStream("/products/monitors.json"), Product[].class));
    }

    private final String name;
    private final int price;
    private final String description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
        this.name = "";
        this.price = 0;
        this.description = "";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && name.equals(product.name) && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }
}
