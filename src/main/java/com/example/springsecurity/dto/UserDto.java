package com.example.springsecurity.dto;

import com.example.springsecurity.api.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Oksiuta Andrii
 * 11.01.2023
 * 10:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Integer id;
  private String name;
  private UserRole userRole;
  private String password;
}
