package com.ppg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppg.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Iterable<Product> listAllProducts() {
        return null;// productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
    	 return null;//return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
    	 return null;//return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
       // productRepository.delete(id);
    }
}
