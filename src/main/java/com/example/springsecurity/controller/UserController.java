package com.example.springsecurity.controller;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Oksiuta Andrii
 * 26.01.2023
 * 10:46
 */

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("registration")
  public String registration() {
    log.info("registration");
    return "users/registration";
  }

  @PostMapping("registration")
  public String registration(UserDto userDto) {
    log.info("create user");
    userService.createUser(userDto);
    return "redirect:/login";
  }

}
