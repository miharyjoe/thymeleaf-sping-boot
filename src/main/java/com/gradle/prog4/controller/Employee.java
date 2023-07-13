package com.gradle.prog4.controller;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Employee {
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String matricule;
    private MultipartFile image;
}

