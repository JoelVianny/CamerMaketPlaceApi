package com.example.camermarket.controller;
import com.example.camermarket.entities.Product;
import com.example.camermarket.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
@RequestMapping("/public/products")
public class ProductController {
    private  final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return  productService.getProduct(id);
    }
    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return  productService.getProducts();
    }

    @PostMapping
    public  Product  createProduct(@RequestBody Product product){
        return  productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product editProduct(@PathVariable long  id,@RequestBody Product product){
       return   productService.editProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public  String deleteProduct(@PathVariable long id){
        return  productService.delete(id);
    }

}
