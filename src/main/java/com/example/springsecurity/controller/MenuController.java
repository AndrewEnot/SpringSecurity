package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Oksiuta Andrii
 * 07.02.2023
 * 10:47
 */
@Controller
@Slf4j
@RequestMapping("menu")
public class MenuController {

  @GetMapping
  public String menu() {
    log.info("menu page");
    return "menu";
  }
}
