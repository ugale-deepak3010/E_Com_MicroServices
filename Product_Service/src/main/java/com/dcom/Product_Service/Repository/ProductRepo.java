package com.dcom.Product_Service.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dcom.Product_Service.Model.Product;

public interface ProductRepo extends MongoRepository<Product, String> {

}
