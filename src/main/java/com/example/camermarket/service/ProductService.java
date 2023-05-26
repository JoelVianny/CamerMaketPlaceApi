package com.example.camermarket.service;

import com.example.camermarket.entities.Product;
import com.example.camermarket.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(Long id){
       return    productRepository.findById(id).orElseThrow(()-> new  IllegalArgumentException("Not found"));
    }

    public List<Product> getProducts(){
        return  productRepository.findAll();
    }

    public Product editProduct(long id, Product product){
        log.info(product.toString());
        Product foundProduct = getProduct(id);
        foundProduct.setName(product.getName());
        foundProduct.setAddress(product.getAddress());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setAttachmentId(product.getAttachmentId());
        foundProduct.setCreatedAt(product.getCreatedAt());
        log.info(foundProduct.toString());

       return productRepository.save(product);
    }

    public Product  createProduct(Product product){
        return  productRepository.save(product);
    }

    public String delete(Long id){
         productRepository.delete(getProduct(id));

         return " product deleted";
    }


}
