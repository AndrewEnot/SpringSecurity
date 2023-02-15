package com.example.springsecurity.controller;

/*
 * @author Oksiuta Andrii
 * 14.02.2023
 * 14:11
 */

import com.example.springsecurity.dto.ProductDto;
import com.example.springsecurity.service.ProductService;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("products")
@Controller
public class ProductController {

  private final ProductService productService;

  @GetMapping(value = "/{id}")
  public String getProductById(Model model, @RequestParam int id) {
    model.addAttribute("productById", productService.getById(id));
    return "products/view/id";
  }

  @GetMapping("add")
  public String addProduct(Model model) {
    log.info("ProductRestController Add Product");
    model.addAttribute("errorMsgs", new ArrayList<>());
    model.addAttribute("product", new ProductDto());
    return "products/add";
  }

  @PostMapping
  public String addProduct(ProductDto productDto) {
    productService.createProduct(productDto);
    return "redirect:/products/add";
  }

  @GetMapping
  public String getProductAll(Model model) {
    model.addAttribute("listProducts", productService.getAllProducts());
    return "products/view/all";
  }

  @DeleteMapping(value = "{id}")
  public String removeProductById(@RequestParam int id) {
    productService.removeProductById(id);
    return "redirect:/menu";
  }

  @DeleteMapping
  public String removeAllProducts() {
    productService.removeAllProducts();
    return "redirect:/menu";
  }
}
