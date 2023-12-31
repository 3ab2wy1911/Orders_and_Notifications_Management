package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> productList;

    //----------------------------------------------------------------

    public ProductService() {
        productList = new ArrayList<>();

        Product product1 = new Product(1,"Dell G15 Laptop",20000);
        Product product2 = new Product(2,"Spaghetti Packet",30);
        Product product3 = new Product(3,"Cassio Watch",4500);
        Product product4 = new Product(4,"HP Laptop",15000);
        Product product5 = new Product(5,"IPhone Pro Max 15",60000);
        Product product6 = new Product(6,"1kg Onions",50);
        Product product7 = new Product(7,"BackPack",450);
        Product product8 = new Product(8,"Balenciaga T-Shirt",600);
        productList.addAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8));
    }

    //----------------------------------------------------------------
    public String getProducts(){    // Printing Available products...
        StringBuilder list = new StringBuilder("Available Products :\n");
        for (Product product : productList){
            list.append("Product Id : ").append(product.getId()).append("\tName: ").append(product.getName()).append("\tPrice : ").append(product.getPrice()).append('\n');
        }
        return list.toString();
    }

    //----------------------------------------------------------------
        public Product getProduct(int id){  // return a single product with id ... used for Placement an order or printing order info..
            for(Product product : productList){
                if(product.getId() == id){
                    return product;
                }
            }
            return null;
        }

}
