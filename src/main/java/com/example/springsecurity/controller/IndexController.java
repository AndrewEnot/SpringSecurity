package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @author Oksiuta Andrii
 * 26.01.2023
 * 10:46
 */

@Controller
@Slf4j
public class IndexController {

  @GetMapping("index")
  public String index() {
    log.info("index page");
    return "index";
  }

  @GetMapping("login")
  public String login() {
    log.info("Login page");
    return "login";
  }

  @GetMapping("403")
  public String error403() {
    log.info("403 page");
    return "403Error";
  }
}
