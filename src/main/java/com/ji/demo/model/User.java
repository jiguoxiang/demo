package com.ji.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    @NotEmpty(message="Email cannot be empty")
    private String email;
    private String password;
    @Max(value = 100, message = "Age should not be bigger than 100")
    @Min(value = 18 ,message = "Age should be at least 18" )
    private int age;
}