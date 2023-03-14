package com.rabindra.dashboardapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rabindra.dashboardapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
