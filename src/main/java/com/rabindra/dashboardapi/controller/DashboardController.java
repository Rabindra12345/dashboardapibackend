package com.rabindra.dashboardapi.controller;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabindra.dashboardapi.model.Product;
import com.rabindra.dashboardapi.repo.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api")
public class DashboardController {

	@Autowired
    private ProductRepository productRepository;

	@CrossOrigin("http://localhost:4200")
    @PostMapping("/products")
    public Product createProduct(@RequestParam("image") MultipartFile image,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("price") Double price) throws IllegalStateException, IOException {
        // Get the original file name
        String fileName = image.getOriginalFilename();
        // Create a path to store the file
        try {
            // code that may throw a FileSystemException
            Path path = Paths.get("/home/oaker/Pictures/STOREIMAGEHERE", fileName);
            image.transferTo(path);


        } catch (FileSystemException ex) {
            // handle the exception
            System.err.println("An error occurred while accessing the file system: " + ex.getMessage());
        }

        // Store the file
        
        // Get the URL of the stored file
        String imageUrl = "/home/oaker/Pictures/STOREIMAGEHERE/" + fileName;
        // Create a new product object with the image URL, name, description, and price
//
//        if(imageUrl.isEmpty()||imageUrl.isBlank()) {
//        	//set image url is null
//        	imageUrl = null;
//        }
        Product product = new Product(name, description, price, imageUrl);
        // Save the product to the database
        return productRepository.save(product);
    }

}
