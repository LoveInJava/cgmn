package com.abha.prep.dto;

import com.abha.prep.validation.NoWhiteSpace;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {
    @NotBlank(message = "Id can not be blank")
    @Size( min = 10, max = 10, message = "Id length should be 10")
    @Pattern(regexp = "[A-Z0-9\\-/']+$", message = "it contains alphanumeric and some special character like as '-' ")
    private String id;
    @NoWhiteSpace
    private String name;
    private int age;
    private String role;
    private long salary;
    private String department;
    private String mobile;
    private String address;

}
