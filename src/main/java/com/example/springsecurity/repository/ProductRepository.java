package com.example.springsecurity.repository;

import com.example.springsecurity.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 06.02.2023
 * 14:59
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
