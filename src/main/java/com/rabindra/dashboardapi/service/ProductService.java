//package com.rabindra.dashboardapi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.rabindra.dashboardapi.model.Product;
//import com.rabindra.dashboardapi.repo.ProductRepository;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private FileStorageService fileStorageService;
//
//    public Product addProduct(MultipartFile file, Product product) {
//        String imageUrl = fileStorageService.storeFile(file);
//        product.setImageUrl(imageUrl);
//        return productRepository.save(product);
//    }
//}
//
